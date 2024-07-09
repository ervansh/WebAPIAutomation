node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a Git repository

git branch: 'master', credentialsId: '28be2fda-e5c8-447a-9bcf-e769ec98b993', url: 'gitolite@git.mediamiser.internal:qa-automation-webapi.git'

      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
     
      if (isUnix()) {
        // sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
       
       sh "'${mvnHome}/bin/mvn' -B -f pom.xml clean test"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   
     
   }
   stage('Results') {
     cucumber fileIncludePattern: '**/*.json', jsonReportDirectory: 'target', parallelTesting: true, sortingMethod: 'ALPHABETICAL'
   }
     
 }
     stage('EmailResults') {
emailext body: '''
<p><span style="color: #2f5597;">Hi all,</span></p>
<p><span style="color: #2f5597;">WebAPI Automation test cases have been executed on Agility <a href="http://jenkinsmaster.agilitypr.internal/">Jenkins server</a>, please refer mentioned link to check the detail results:</span></p>
<ul style="margin-top: 0in;">

<h3>Cucumber Results:</h3>
<ul>
<li><a href="$build_url/cucumber-html-reports/overview-features.html"><span style="color: blue;">Click here</span></a> <span style="color: #385723;">to view the complete summary results</span></li>
<li><a href="$build_url/cucumber-html-reports/overview-failures.html">Click here</a> <span style="color: red;">to view only failed results</span><span style="color: red;"></span><span style="color: red;"></span></li>
</ul>

<h3>Pass-Fail Summary:</h3>
<p><code><strong><span style="color: #008000;">${BUILD_LOG_REGEX, regex="^.*?Scenarios.*?$", linesBefore=0, linesAfter=2, maxMatches=5, showTruncatedLines=false, escapeHtml=true}</span></strong></code></p>


<h3>Failure Report:</h3>
<pre><span style="color: #ff0000;">${BUILD_LOG_REGEX, regex="^.*?Failed TC :.*?$", linesBefore=0, linesAfter=0, maxMatches=500, showTruncatedLines=false,escapeHtml=true }</span> </pre>

<p>Thanks,</p>
<p>Agility Automation Bots</p>
<p><em><strong></strong></em></p>
<p><em><strong>"</strong></em><span style="color: purple;"><em>The only certainties in life are death, taxes and bugs in code."</em> </span></p>




''', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS',


to:  'vikas.singh@agilitypr.com ,amit.rana@agilitypr.com, ishita.shrivastava@agilitypr.com , sonali.sinha@agilitypr.com, sweta.kukreti@agilitypr.com ,muhammad.irfan@agilitypr.com, jaya.ghanata@agilitypr.com'


   }