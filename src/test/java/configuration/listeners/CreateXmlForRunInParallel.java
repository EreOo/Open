package configuration.listeners;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.testng.IAlterSuiteListener;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created Vladimir Shekhavtsov.
 * Listener for start run with all tests. Useful for Jenkis.
 */
public class CreateXmlForRunInParallel implements IAlterSuiteListener {
    private static final String PATH_WITH_TESTS = "functionality";
    private static Set<Method> allTestsInProject;

    private static Set<Method> getAllTests() {
        if (allTestsInProject == null) {
            Reflections reflections = new Reflections(PATH_WITH_TESTS, new MethodAnnotationsScanner());
            allTestsInProject = reflections.getMethodsAnnotatedWith(Test.class);
        }
        return allTestsInProject;
    }

    private static Map<String, String> getAllTestClasses(Set<Method> methodSet) {
        Map<String, String> classNameAndPathMap = new HashMap<>();
        for (Method testMethod : methodSet) {
            List<String> groups = Arrays.asList(testMethod.getAnnotation(Test.class).groups());

            String classPath = testMethod.getDeclaringClass().getName();
            if (!classNameAndPathMap.containsValue(classPath)) {
                classNameAndPathMap.put(testMethod.getName(), classPath);
            }
        }
        return classNameAndPathMap;
    }

    @Override
    public void alter(List<XmlSuite> suites) {
        if (!suites.isEmpty()) {
            XmlSuite modifySuite = suites.get(0);
            List<XmlTest> xmlTestList = new ArrayList<>();
            Map<String, String> allTestClasses;

            allTestClasses = getAllTestClasses(getAllTests());

            for (Map.Entry<String, String> entry : allTestClasses.entrySet()) {
                XmlTest xmlTest = new XmlTest(modifySuite);
                XmlClass xmlClass = new XmlClass(entry.getValue());
                xmlTest.setClasses(Collections.singletonList(xmlClass));
                xmlTest.setName(entry.getKey());
                xmlTestList.add(xmlTest);
            }
            modifySuite.setTests(xmlTestList);

            modifySuite.setThreadCount(Integer.parseInt(System.getProperty("thread")));

            System.out.println(modifySuite.toXml());
        }
    }
}
