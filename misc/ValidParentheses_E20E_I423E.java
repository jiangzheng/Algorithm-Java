package misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_E20E_I423E {
	/**
	 * Use Stack.
	 * Time: O(n); Space: O(1) 
	 */
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for (Character c : s.toCharArray()) {
			if (stack.isEmpty() || map.containsKey(c)) {	// empty stack or c is '(', '[', or '{'
				stack.push(c);
			} else {
				if (!c.equals(map.get(stack.pop()))) {	// c is ')', ']', or '}'
					return false;
				}
			}
		}
		
		return stack.isEmpty();	// not empty -> not valid
	}
	
	@SuppressWarnings("serial")
	public static final Map<Character, Character> map = new HashMap<Character, Character>() {{
		put('(', ')');
		put('[', ']');
		put('{', '}');
	}};
	
	public static void main(String[] args) {
		ValidParentheses_E20E_I423E obj = new ValidParentheses_E20E_I423E();
		System.out.println(obj.isValid(null));	// false
		System.out.println(obj.isValid(""));	// false
		
		System.out.println(obj.isValid("([)]"));	// false
		System.out.println(obj.isValid("}}}{{{"));	// false
		
		System.out.println(obj.isValid("()[]{}"));	// true
		System.out.println(obj.isValid("{[()]({}[])}"));	// true
		
	}
}

/**
 * LeetCode #20
 * LintCode #423
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 *   determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

Azure-MS
R No	Job Role	Role	Self Paced Learning Path	Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	Data Engineer	Azure Data Engineer Associate	Azure fundamentals (Optional)	8:59	11				common across all the certifications
1		DP-200 (Required)	Perform data engineering with Azure Databricks	7:49	9				
1		DP-201 (Required)	Azure for the Data Engineer	1:51	3				
1		AZ-900 (Optional Prerequisite)	Implement a Data Warehouse with Azure SQL Data Warehouse	3:21	4				
1			Large Scale Data Processing with Azure Data Lake Storage Gen2	2:05	3				
1			Extract knowledge and insights from your data with Azure Databricks	4:21	6				
1			Implement a Data Streaming Solution with Azure Streaming Analytics	1:14	2				
1			Work with relational data in Azure	3:20	4				common for data engineer and developer
1			Work with NoSQL data in Azure Cosmos DB	5:55	8				common for data engineer and developer
1			Store data in Azure	3:50	5				common for data engineer and developer
2	DataOps Engineer	Azure DevOps Engineer Expert	Evolve your DevOps practices	1:17	3				
2		AZ-400 (Required)	Build applications with Azure DevOps	6:10	7				
2			Run quality tests in your build pipeline by using Azure Pipelines	1:07	9				
2			Assess your existing software development process	0:17	5				
2			Scan open source components for vulnerabilities and license ratings in Azure Pipelines	0:27	6				
2			Create a build pipeline with Azure Pipelines	1:03	10				
2			Scan code for vulnerabilities in Azure Pipelines	0:53	9				
2			Manage build dependencies with Azure Artifacts	0:39	9				
2			Implement a code workflow in your build pipeline by using Git and GitHub	1:13	10				
2			Choose an Agile approach to software development	0:38	5				
2			Host your own build agent in Azure Pipelines	0:48	7				
2			Get started with Azure DevOps	0:22	5				
2		AZ-203 (Prerequisite)	Azure fundamentals (Optional)	8:59	11				common across all the certifications
2		AZ-900 (Optional Prerequisite)	Build applications with Azure DevOps	6:10	7				common for developer & administrator
2			Build automated workflows to integrate data and apps with Azure Logic Apps	2:49	4				
2			Connect your services together	3:31	4				
2			Create serverless applications	6:15	7				
2			Deploy a website to Azure with Azure App Service	3:50	5				
2			Deploy a website with Azure virtual machines	4:18	4				
2			Extract knowledge and insights from your data with Azure Databricks	4:21	6				common for data engineer and developer
2			Introduction to machine learning with Python and Azure Notebooks	2:11	3				
2			Manage resources in Azure	4:15	5				common for developer & administrator
2			Perform data engineering with Azure Databricks	7:49	9				common for data engineer and developer
2			Secure your cloud data	6:45	8				common for developer & administrator
2			Work with relational data in Azure	3:20	4				common for data engineer and developer
2			Work with NoSQL data in Azure Cosmos DB	5:55	8				common for data engineer and developer
2		OR	Store data in Azure	3:50	5				common for data engineer and developer
2		AZ-103 (Prerequisite)	Administer containers in Azure	3:45	5				
2		AZ-900 (Optional Prerequisite)	Azure fundamentals (Optional)	8:59	11				common across all the certifications
2			Build applications with Azure DevOps	6:10	7				common for developer & administrator
2			Secure your cloud data	6:45	8				common for developer & administrator
2			Administer infrastructure resources in Azure	9:34	10				
2			Manage resources in Azure	4:15	5				common for developer & administrator
3	Solution Architect	Azure Solutions Architect Expert	Perform data engineering with Azure Databricks	0.325694444	9				
3		AZ-303 (Required)	Extract knowledge and insights from your data with Azure Databricks	4:21	6				
3		AZ-304 (Required)	Azure fundamentals (Optional)	8:59	11				common across all the certifications
3		AZ-900 (Optional Prerequisite)	Architect great solutions in Azure	4:17	5				
3			Manage resources in Azure	4:15	5				common for developer & administrator
3			Build applications with Azure DevOps	6:10	7				

Azure-Udemy
R No	Job Role	Role	Self Paced Learning Path	Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	Data Engineer	Azure Data Engineer Associate							
1		DP-200 (Required)	Azure Data Engineer Technologies for Beginner (DP-200, DP-201)	12:00	18				There is two separate courses as well, from the same author 
1		DP-201 (Required)	Azure Data Engineer Associate Practice Exams	08:00	163				Reference only
1		AZ-900 (Optional Prerequisite)							
1									
2	DataOps Engineer	Azure DevOps Engineer Expert							
2		AZ-400 (Required)	Designing and Implementing Microsoft DevOps Solutions	20:00	9				IBM Udemy
2			Azure DevOps Engineer Expert Practice Exams	08:00	240				
2									
3	Solution Architect	Azure Solutions Architect Expert							
3		AZ-303 (Required)	Azure Architecture Technologies Exam Prep 2020	11:32	22	2020-11-22	2020-12-18	Completed	IBM Udemy
			Azure Hands-on practice	23:59		2020-12-25		In Progress	
3		AZ-304 (Required)	Azure Architect Design Exam Prep 2020	06:10	21				IBM Udemy
3		AZ-900 (Optional Prerequisite)	Azure Practice Exams	12:00	16				CherCher external link
3									
3									

snowflake
R No	Job Role	Certification	Self Paced Learning Path	Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	SnowPro Specialist	SnowPro Core Certified							
1			Hands on Essentials	1.00	3.00	2020-06-03	2020-06-03	Completed	
1			Level Up - First Concepts	2.00	5.00	2020-06-04	2020-06-04	Completed	
1			Level Up - Performance	1.50	4.00	2020-06-05	2020-06-05	Completed	
1			Snowflake Advanced Capabilities	1.50	5.00	2020-06-06	2020-06-06	Completed	
1			Snowflake Customer Onboarding	2.00	7.00	2020-06-07	2020-06-07	Completed	
1			Snowflake Transformation	2.00	4.00	2020-06-08	2020-06-08	Completed	
1			Snowflake Certification Information	2.00	3.00	2020-06-09	2020-06-09	Completed	
1			Snowflake Certfication Flashcards - Quizlet	4.00	1.00	2020-06-08	2020-06-09	Completed	222 questions
									
2	SnowPro Architect	SnowPro Advanced Architect							
2			SnowPro Advanced Archite Overview						
2			SnowPro Advanced Archite Study Guide						Link to mindtickle. Need an account to access the guide
2			Snowflake - Architect Preparation Exams	8.00	5.00				Check for other exam questions as well on the internet
2		Snowflake Company Overview	Snowflake Website	0.02					Skip if you are a SnowPro
2			About Snowflake	0.02					Skip if you are a SnowPro
2			Meet the Two Guys Who Built the #1 Cloud Data Platform	0.02					Skip if you are a SnowPro
2			Reinventing the Data Warehouse (Video)	0.02					Skip if you are a SnowPro
2			Introduction to Snowflake Cloud Data Platform (Video) 	0.03					Skip if you are a SnowPro
2			Snowflake University, LevelUp: Snowflake’s Key Concepts	0.10					Skip if you are a SnowPro
2		How Snowflake is Different	Introduction to Snowflake - Key Concepts & Architecture	0.15					Skip if you are a SnowPro
2			Snowflake Getting Started Documentation	0.30					Skip if you are a SnowPro
2			Getting Started with Snowflake - Key Concepts (Video)	0.07					Skip if you are a SnowPro
2			Before You Begin	0.05					Skip if you are a SnowPro
2			See Snowflake in 8 Minutes (Video)	0.09					Skip if you are a SnowPro
2		Snowflake Editions & Deployments	Snowflake University, LevelUp: Snowflake Account Options & Assurances	0.30					
2			Technology Partners - AWS	0.15					
2			Technology Partners  - Azure	0.15					
2			Technology Partners  - GCP	0.15					
2			Snowflake Regions	0.20					
2			Snowflake Editions	0.30					
2		Key Features	Overview of Key Features	0.60					
2			Introduction to Semi Structured Data	0.45					
2			Bringing Together Structured and Semi Structured Data	0.05					
2			Semi-Structured Data Types	0.15					
2			Querying Semi-Structured Data	0.60					
2			Continuous Data Protection	0.15					
2			Snowflake Fast Clone	0.15					
2			A Quick Look at Zero Copy Cloning	0.05					
2			Cloning in Snowflake (Video)	0.20					
2			Using Persisted Query Results	0.15					
2			Accelerating BI Queries with Caching in Snowflake (Video)	0.05					
2			Top 10 Cool Snowflake Features, #10: Snowflake Query Result Sets Available to Users via History	0.15					
2			Sharing Data in Snowflake	0.15					
2		Snowflake Pricing & Editions	Snowflake Editions & Pricing 	0.15					
2			Snowflake Regions	0.20					
2		Snowflake Architecture	Database Storage	0.10					Skip if you are a SnowPro
2			Query Processing	0.10					Skip if you are a SnowPro
2			Cloud Services	0.05					Skip if you are a SnowPro
2			Snowflake University, LevelUp: Snowflake’s Three Layer Design(Document + Quiz) 		0.20				Additional Resources: Redundant. Try the quiz
2			Snowflake Architecture, Cloud Services (Video)		0.05				Additional Resources: Retired. Redundant Content
2			FundamentalData Warehouse Architecture (Paper)		0.45				Additional Resources: Skip if you are familiar with DW
2		Interfaces & Connectivity	Snowflake Web Interface (UI)	0.30					To install SnowSQL and test connection
2			SnowSQL (CLI)	0.90					
2			Connector Ecosystem	1.20					
2			Partner Connector Ecosystem	0.20					
2		Exercise - HOLG	Module 1: Prepare your Lab Environment	0.15					Module 1 only. Skip if you already have an account
2		Exercise - HOLG	Module 2: The Snowflake User Interface & Lab “Story” 	0.15					Module  2 only. Skip if you already familiar with Web UI
2			Quick Tour of the Web Interface(Document + Video) 		0.15				Additional Resources: Skip if you are already familiar
2			User Interface Quick Tour(Video) 		0.05				Additional Resources: Skip if you are already familiar
2			Snowflake University, Hands on Web UI Essentials (Video, Labs + Project work)		1.50				Additional Resources: Skip if you are already familiar
2			Snowflake University, Level Up: Snowflake Ecosystem (Document + quiz) 		1.20				Additional Resources: Skip if you are already familiar
2			Snowflake University, Snowflake User Interface Walkthrough(Video) 		0.30				Additional Resources: Retired
2			Snowflake University, Snowflake Clients and Ecosystem (Video)		0.30				Additional Resources: Retired
2			Getting Started on Snowflake with Partner Connect(Video)		0.06				Additional Resources:
2		Catalog & Objects	Database & Schema	1.20					
2			Tables	1.20					
2			Views	1.20					
2			Data Types	1.20					
2		Data Sharing	Sharing Configuration & Access Control options	0.60					
2			Secure Data Sharing	0.30					
2			Providers, Consumers & Reader Accounts	0.15					
2			Creating & Managing Shares	0.15					
2		Exercise - HOLG	Module 9: Data Sharing	0.45					
2			Data Sharing for Dummies(eBook)		2.40				Additional Resources: Ebook 68 pages
2			Snowflake University, Data Sharing in Snowflake (Video)		0.60				Additional Resources: Retired Conent
2			Snowflake University, Hands-On Sharing, Marketplace, & Exchanges Workshop (Video, Labs + Project work)		3.00				Additional Resources: Badge workshop 2
2		Virtual Warehouses - Compute	Warehouses & Types	0.15					
2			Warehouse Sizing & Scaling	0.15					
2			Credit Usage	0.15					
2			Warehouse Management	0.15					
2			Warehouse Caching	0.10					
2			Warehouse Monitoring	0.20					
2			Tackling High Concurrency with Multi-Cluster Warehouses (Video)		0.05				Additional Resources: 
2			Snowflake University, LevelUp: Query & Result(Video + Quiz)		0.30				Additional Resources: LevelUp, Revise once
2		Storage and Protection - Storage	Micro partitions	0.45					
2			Metadata	0.15					
2			Clustering	1.20					
2			Data Storages –Cost & Retention	0.45					
2			Table Types, File Formats	0.45					Covered under catalog & objects, key features
2			Storage Monitoring	0.15					
2			Meta Data Archiving with Snowflake (Blog) 		0.30				Additional Resources:
2			Snowflake University, Level Up: Container Hierarchy(Document + quiz) 		0.60				Additional Resources:
2			Top 10 Cool Snowflake Features, #7: Snowflake Fast Clone(Blog + video)		0.30				Additional Resources:
2		Storage and Protection - Continuous Data Protection	Time Travel, Fail Safe	0.90					
2			Data Encryption	0.60					
2			Security –Network policies	0.90					
2			Multi-Factor Authentication (MFA)	0.60					
2			Federated Authentication & SSO	1.80					
2		Exercise - HOLG	Module 7: Using Time Travel		0.30				
2			Snowflake Continuous Data Protection (White Paper) 		0.45				Additional Resources:
2			Snowflake University, Snowflake Backup & Recover (Video)		0.60				Additional Resources: Access level is restricted
2		Data Movement - Data Loading	Stages, file format, pipe	0.45					
2			Bulk Load using COPY	0.20					
2			Loading Consideration & Load Management	0.30					
2			Continuous Load Options –Snowpipe	0.30					
2			Error handling & Troubleshooting	0.30					
2		Exercise - HOLG	Module 3: Preparing to Load Data 	0.30					
2		Exercise - HOLG	Module 4: Loading Data 	0.45					
2			Getting Started -Introduction to Databases and Querying(Video)		0.06				Additional Resources:
2			How to Load Terabytes intoSnowflake -Speeds, Feeds and Techniques(Blog) 		0.30				Additional Resources:
2			Snowflake University, Snowflake Data Loading Best Practices (Video)		0.90				Additional Resources: Retired Content
2		Data movement - Data Unloading	Unloading data from Snowflake to External Cloud Storage (S3,GCS,AZURE BLOB)	1.20					
2			Unloading data from Snowflake to Internal Snowflake Storage	0.30					
2			Unloading data from Snowflake to Local / Network Drive 	0.15					Pointing to data unloading consideration!! Wrong link?
2			Data Unloading Considerations	0.30					
2		Snowflake Connector for Kafka	Schema of Topics for Kafka Topics	0.45					
2			Workflow for the Kafka Connector	0.30					
2		Semi Structured Data	Different Formats, Variant Table Type 	0.30					
2			Native Syntax, Flattening DATA	0.15					
2		Exercise - HOLG	Module 6: Working with Semi-Structured Data	0.90					
2			Best Practices for Using Tableau with Snowflake (White Paper)		3.00				Additional Resources: 63 pages. Skip it
2			Easily Loading and Analyzing Semi-Structured Data in Snowflake (Video)		0.05				Additional Resources:
		Performance & Tuning - Performance Management	Query Performance & Analysis 	1.20					
			SQL optimization						No link provided
			Load Testing						No link provided
			Clustering & Materialized Views 	1.80					
			Query Profile	1.20					
			Caching						No link provided. Already covered in LevelUP
			Using Materialized Views to Solve Multi-Clustering Performance Problems Snowflake University, Level Up: 		0.45				Additional Resources:
			Caching (Video + Quiz)		0.45				Additional Resources: Practice this lab
			Snowflake University, SQL Support and Usage in Snowflake (Video)		0.90				Additional Resources: Retired Content.
		Account & Security - Account Management	Managing Your Snowflake Account 	0.90					
			WAREHOUSE & Storage credit usage 	0.45					
			Materialized Views	0.15					
			Auto /Re Clustering	0.15					
			DR & Replication	0.15					
			Information Schema	0.45					
			Differences Between Account Usage and Information Schema	0.15					
		Exercise - HOLG	Module 8: Role Based Access Controls and Account Admin	0.60					
			Snowflake Community Administering Snowflake Guide 		0.60				Additional Resources: Useful cheatsheets
			Snowflake University, Snowflake Administration Overview		1.20				Additional Resources: Retired Content
		Security	Access Control	0.60					
			Role Hierarchy and Privilege Inheritance 	0.30					
			Multi-Factor Authentication (MFA) 	0.30					
			Data Encryption	0.90					
			Network Security & Policies	0.90					
			Federated Authentication & SSO	1.80					
			Snowflake Editions	0.30					Already covered in previous sections
		Exercise - HOLG	Module 8: Role Based Access Controls and Account Admin	1.20					
			Snowflake Security Overview (Video)	0.05					Additional Resources:
			Data Protection with Time Travel in Snowflake (Video)	0.05					Additional Resources:
			Crucial Security Controls for Your Cloud Data Warehouse (Video) 	0.05					Additional Resources:
			Snowflake University, Snowflake Security Overview (Video)	0.60					Additional Resources: Retired Content
									
			Total Estimated Time	74.00	35.00				

Kafka
R No	Job Role	Certification	Self Paced Learning Path	Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	Kafka Developer	Confluent Certified Kafka Developer	Apache Kafka Fundamentals	7.50	123				
1			Kafka Connect	4.50	55				
1			Kafka Streams for Data Processing	4.75	76				
1			Confluent Schema Registry and REST Proxy	4.30	58				
1			Confluent KSQL	3.75	36				
1			Kafka Cluster Setup And Administration	4.00	48				
1			Kafka Security	4.00	43				Not a exam topic
1			Practice Exams	12.00	3				150 questions in total
									
									
			Total	44.80					

Ansible
R No	Job Role	Certification	Self Paced Learning Path	Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	Configuration Engineer	Red Hat Certified Specialist in Advanced Automation: Ansible Best Practices	Ansible Certification - Red Hat EX447	0.50	1				
1			Exam details	0.25	1				
1			Yourlearning - Ansible Automation	17.50	25				

DataEngineer - WIP
D No	Technology		Module Name	Duration Minutes	Practice Minutes	Date Started	Date Completed	Comments
1	Linux	Session from Ramesh	Linux Commands	120	240			
2	Unix	Session from Ramesh	Unix Scripting	120	300			
3	Big Data	https://ibm-learning.udemy.com/course/hadoopinrealworld/	Introduction to Big Data	36	0			
4	HDFS	https://ibm-learning.udemy.com/course/hadoopinrealworld/	HDFS	56	60			
5	MapReduce	https://ibm-learning.udemy.com/course/hadoopinrealworld/	MapReduce	102	0			
6	Hive	https://ibm-learning.udemy.com/course/hadoopinrealworld/	Apache Hive	110	120			
7	Hive	https://ibm-learning.udemy.com/course/hadoopinrealworld/	Hive window & Analytical Functions	25	60			
8	Hadoop Architecture	https://ibm-learning.udemy.com/course/hadoopinrealworld/	Architecture	55	0			
9	Big Data	https://ibm-learning.udemy.com/course/hadoopinrealworld/	File formats	180				
10	Hadoop	https://ibm-learning.udemy.com/course/hadoopinrealworld/	Trouble shooting & Optimizations	50				Ignore PIG modules
11	Python	https://www.youtube.com/watch?v=YYXdXT2l-Gg&list=PL-osiE80TeTt2d9bfVyTiXJA-UTHn6WwU	100+ modules					Start with basics and refer as and when needed
12	PIP	Session from Ramesh	PIP commands	60	120			
13	YUM	Session from Ramesh		60	60			
14	APT-GET	Session from Ramesh		60	60			
15	Sublime Text	Session from Ramesh		30	60			
16	VS Code	Session from Ramesh		30	60			
17	Dcoker	Session from Ramesh		60	60			
18	MobaXterm	Session from Ramesh		30	0			
19	GitHub	Session from Ramesh		45	60			
20	Jira	Session from Ramesh		45	60			
21	HDP Sandbox	https://www.cloudera.com/downloads/hortonworks-sandbox/hdp.html	VirtualBox	30	30			Horton sandbox - hadoop environment. Download VirtualBox platform
22	Installing Virtual Box	https://www.youtube.com/watch?v=83pnNc3hwX8		7	15			Install virtual box and a CentOS VM (example)
23	AWS Cloud	AWS!A1	AWS Cloud Practitioner	720	180			
24	Snowflake	snowflake!A1		600	240			
25	DI Project Checklist							

Snowflake Migration
D No	Domain	Artifact Link	Description	Comments
1	migration	https://support.snowflake.net/s/article/So-You-Want-to-Migrate-to-Snowflake-Part-One	Midsize company, migration process steps	15 minute read
2	migration	https://support.snowflake.net/s/article/So-You-Want-To-Migrate-To-Snowflake-Part-Two	Part 2 of above use case	
3	migration	https://support.snowflake.net/s/migrations	snowflake migration support page	
4	FAQ	https://spn.snowflake.com/s/contentdocument/0693r000007MNvlAAG	Snowflake TOP 20 FAQ	
