#### Test task-project for Open Bank.
--------------------------------------------------------<br/>
##### How start tests?
You could start each test manual:<br/>
find tests - src\test\java\functionality\... <br/>
You could star all tests by testng.xml:<br/>
find xml - src\test\resources\run_tests.xml (just clik right mouse putton and click start)

------------------------------------------------------<br/>
##### Profiles
Project 100% working with Google Chrome. <br/>
Chrome is default browser for project.<br/>
If you want run test with another browser - add your new profile like profile Chrome in pom.xml<br/>
Tests run in 1 thread (default) if you wand start parallel run - change thread count in profile.<br/>
NOTE: <br/>
For parallel runs please use other tests yandex account for each test!!! Or run will have conflicts!!!<br/>

------------------------------------------------------<br/>
##### WARNING
If you use Windows chrome could make zombie process!<br/>
Use after run next command: taskkill /F /IM chrome.exe /T  <br/>
It kill all chrome process!<br/>
For UNIX it's not problem.<br/>
------------------------------------------------------<br/>
NOTE: you must have java and chrome for correct work.
