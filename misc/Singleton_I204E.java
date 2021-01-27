package misc;

public final class Singleton_I204E {
	/**
	 * Implementation #1: Lazy initialization.
	 */
	private static Singleton_I204E instance = null;
	
	private Singleton_I204E() {
	}
	
	public static synchronized Singleton_I204E getInstance() {
		if (instance == null) {
			instance = new Singleton_I204E();
		}
		return instance;
	}
  
	public static void main(String[] args) {
		Singleton_I204E a = Singleton_I204E.getInstance();
		Singleton_I204E b = Singleton_I204E.getInstance();
		System.out.println(a.equals(b));
	}
}

/**
 * LintCode #204
 * Singleton is a most widely used design pattern. 
 * If a class has and only has one instance at every moment, we call this design as singleton. 
 * For example, for class Mouse (not a animal mouse), we should design it in singleton.
 * You job is to implement a getInstance method for given class, 
 *   return the same instance of this class every time you call this method.
 * Example in Java:
 * A a = A.getInstance();
 * A b = A.getInstance();
 * a should equal to b.
 * If we call getInstance concurrently, can you make sure your code could run correctly?
 */

AWS
R No	Job Role	Certification	Self Paced Learning Path		Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	Data Engineer	AWS Certified Cloud Practitioner								
1		For udemy course, use ibm udemy link	https://www.udemy.com/course/aws-certified-cloud-practitioner-training-course/		12.00	171	2020-03-26	2020-03-29	Completed	Udemy
1		for the same course using ibm link	https://d0.awsstatic.com/whitepapers/aws-overview.pdf		6.00	1	2020-03-29	2020-03-30	Completed	aws services overview, 94 pages, 
1		https://ibm-learning.udemy.com/	https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf		4.00	1	2020-03-30	2020-03-31	Completed	aws well-architected framework, 76 pages
1			http://d1.awsstatic.com/whitepapers/aws_pricing_overview.pdf		1.00	1	2020-04-01	2020-04-01	Completed	aws pricing, 21 pages
1			Practice exams		4.00	2	2020-03-29	2020-03-31	Completed	Available as part of Udemy course
1			Hands on practice		13.00	1	2020-03-26	2020-03-29	Completed	On aws cloud, using free services
1			Total		40.00					Add additional 10 hours if needed
2	Solution Architect	AWS Solutions Architect Associate								
2			https://www.udemy.com/course/aws-certified-solutions-architect-associate-saa-c02/		23.50	284				Preferred course
2		or	https://www.udemy.com/course/aws-certified-solutions-architect-associate/		24.00	107	2020-04-18	2020-05-26	Completed	
2			https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf		4.00	1	2020-05-26	2020-05-27	Completed	aws well-architected framework, 76 pages
2		For udemy course, use ibm udemy link	https://d0.awsstatic.com/whitepapers/AWS%20Storage%20Services%20Whitepaper-v9.pdf		2.00	1	2020-05-29	2020-05-29	Completed	aws storage services, 44 pages
2		for the same course using ibm link	https://d0.awsstatic.com/whitepapers/aws-security-best-practices.pdf		6.00	1	2020-05-30	2020-05-31	Completed	aws security best practices, 73 pages
2		https://ibm-learning.udemy.com/	Practice exams		18.00	4	2020-05-26	2020-06-03	Completed	
2			Hands on practice		24.00	1	2020-04-19	2020-05-26	Completed	On aws cloud, using free services
2			Review notes		6.00	1	2020-06-01	2020-06-02	Completed	
2			Total		84.00					Add additinoal 10 hours if needed
6	Data Engineer	AWS Developer Associate								
6			https://www.udemy.com/course/aws-certified-developer-associate-dva-c01/		19.00	221				
		For udemy course, use ibm udemy link	https://www.udemy.com/course/aws-certified-developer-associate/		15.50	127	2020-06-09	2020-06-23	Completed	
6		for the same course using ibm link	https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf		4.00	1	2020-06-24	2020-06-24	Completed	aws well-architected framework, 76 pages
6		https://ibm-learning.udemy.com/	https://d1.awsstatic.com/whitepapers/aws-security-whitepaper.pdf		6.00	1			Skipped	aws security, 88 pages
6			https://d0.awsstatic.com/whitepapers/aws-security-best-practices.pdf		6.00	1	2020-06-25	2020-06-25	Completed	aws security best practices, 73 pages
6			https://d1.awsstatic.com/whitepapers/microservices-on-aws.pdf		2.00	1	2020-06-26	2020-06-26	Completed	microservics on aws, 29 pages
6			https://d0.awsstatic.com/whitepapers/compliance/Intro_to_Security_by_Design.pdf		1.50	1	2020-06-26	2020-06-26	Completed	aws security by design, 14 pages
6			https://d0.awsstatic.com/whitepapers/DevOps/practicing-continuous-integration-continuous-delivery-on-AWS.pdf		3.00	1	2020-06-24	2020-06-25	Completed	CI/CD delivery on aws, 30 pages
6			https://d1.awsstatic.com/whitepapers/AWS_Blue_Green_Deployments.pdf		3.00	1	2020-06-27	2020-06-27	Completed	aws blue green deployment, 35 pages
6			https://d1.awsstatic.com/whitepapers/DevOps/running-containerized-microservices-on-aws.pdf		2.00	1	2020-06-28	2020-06-28	Completed	running containerized on aws, 18 pages
6			https://d1.awsstatic.com/whitepapers/serverless-architectures-with-aws-lambda.pdf		6.00	1	2020-06-28	2020-06-29	Completed	aws lambda, 43 pages
6			Practice exams		12.00	4	2020-06-26	2020-06-29	Completed	
6			Hands on practice		16.00	1	2020-06-09	2020-06-23	Completed	
6			Review notes		10.00	1	2020-06-29	2020-06-30	Completed	
6			Total		87.00					Add additional 10 hours if needed
4	Security Specialist	AWS SysOps Administrator Associate								
4			https://www.udemy.com/course/ultimate-aws-certified-sysops-administrator-associate/		19.50	236	2020-06-30		In Progress	On hold due to kafka certification
4		For udemy course, use ibm udemy link	https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf		3.00	1				aws kms best practices, 24 pages
4		for the same course using ibm link	https://d0.awsstatic.com/whitepapers/Security/AWS_Security_Best_Practices.pdf?refid=em_		3.00	1				GDPR compliance on aws, 34 pages
4		https://ibm-learning.udemy.com/	http://d0.awsstatic.com/whitepapers/Security/AWS%20Security%20Whitepaper.pdf		6.00	1				aws security, 88 pages
4			https://d0.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf		1.50	1				aws key compliance questions, 8 pages
4			https://media.amazonwebservices.com/AWS_Development_Test_Environments.pdf		6.00	1				aws compliance quick reference, 58 pages
			https://d0.awsstatic.com/whitepapers/Backup_Archive_and_Restore_Approaches_Using_AWS.pdf		3.00					
			https://media.amazonwebservices.com/AWS_Amazon_VPC_Connectivity_Options.pdf		1.50					
4			http://d0.awsstatic.com/whitepapers/aws_pricing_overview.pdf		1.50	1				aws security by design, 14 pages
4			Practice exams		12.00	4				
4			Hands on practice		24.00	1				
4			Review notes		4.00	1				
4			Total		85.00					Add additional 20 hours if needed
3	DevOps Engineer	AWS DevOps Engineer Professional								
3			https://www.udemy.com/course/aws-certified-devops-engineer-professional-hands-on/		20.50	224				
3		For udemy course, use ibm udemy link	https://d0.awsstatic.com/whitepapers/DevOps/infrastructure-as-code.pdf		3.00	1				aws infrastructure as code, 30 pages
3		for the same course using ibm link	https://d1.awsstatic.com/whitepapers/microservices-on-aws.pdf		2.00	1				microservics on aws, 29 pages
3		https://ibm-learning.udemy.com/	https://d0.awsstatic.com/whitepapers/AWS_DevOps.pdf		2.00	1				devops on aws, 20 pages
3			https://d1.awsstatic.com/whitepapers/DevOps/Jenkins_on_AWS.pdf		4.00	1				jenkins on aws, 44 pages
3			https://media.amazonwebservices.com/AWS_Development_Test_Environments.pdf		2.00	1				development and test on aws, 17 pages
3			https://d1.awsstatic.com/whitepapers/DevOps/running-containerized-microservices-on-aws.pdf		2.00	1				running containerized on aws, 18 pages
3			https://d1.awsstatic.com/whitepapers/AWS_Blue_Green_Deployments.pdf		3.00	1				aws blue green deployment, 35 pages
3			https://d0.awsstatic.com/whitepapers/DevOps/practicing-continuous-integration-continuous-delivery-on-AWS.pdf		3.00	1				CI/CD delivery on aws, 30 pages
3			https://d1.awsstatic.com/whitepapers/DevOps/import-windows-server-to-amazon-ec2.pdf		2.00	1				powershell on aws, 16 pages
3			Practice exams		12.00	4				
3			Hands on practice		24.00	1				
3			Review notes		10.00	1				
3			Total		100.00					Add additional 20 hours if needed
5	Solution Architect	AWS Solutions Architect Professional								
5			https://www.udemy.com/course/aws-solutions-architect-professional/		13.00	132				
5		For udemy course, use ibm udemy link	https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf		4.00	1				aws well-architected framework, 76 pages
5		for the same course using ibm link	https://d1.awsstatic.com/whitepapers/aws-security-whitepaper.pdf		6.00	1				aws security, 88 pages
5		https://ibm-learning.udemy.com/	https://d0.awsstatic.com/whitepapers/aws-security-best-practices.pdf		6.00	1				aws security best practices, 73 pages
5			https://d1.awsstatic.com/whitepapers/microservices-on-aws.pdf		2.00	1				microservics on aws, 29 pages
5			https://d0.awsstatic.com/whitepapers/compliance/Intro_to_Security_by_Design.pdf		1.30	1				aws security by design, 14 pages
5			https://d0.awsstatic.com/whitepapers/DevOps/practicing-continuous-integration-continuous-delivery-on-AWS.pdf		3.00	1				CI/CD delivery on aws, 30 pages
5			https://d0.awsstatic.com/whitepapers/Backup_and_Recovery_Approaches_Using_AWS.pdf		3.00	1				BandR, pages 26
5			https://d1.awsstatic.com/whitepapers/aws-disaster-recovery.121b65092f931567af5370b47dd12cb18866089c.pdf		3.00	1				disaster and recovery, pages 22
5			Practice exams		12.00	4				
5			Hands on practice		56.50	1				
5			Review notes		10.00	1				
5			Total		120.00					Add additional 20 hours if needed
6	Big Data Engineer	AWS Certified Data Analytics - Speciality	AWS Certification Page Link							
6		AWS DAS-C01	Exam Guide		0.50	1				
6		Exam Duration - 170 minutes 65 Qs	https://ibm-learning.udemy.com/course/aws-big-data/		12.50	12				
6			Big Data Options on AWS	https://d1.awsstatic.com/whitepapers/Big_Data_Analytics_Options_on_AWS.pdf?did=wp_card&trk=wp_card	2.00	1				Additional Reference
6			Lamda Architecture for Batch and Stream Processing	https://d1.awsstatic.com/whitepapers/lambda-architecure-on-for-batch-aws.pdf?did=wp_card&trk=wp_card	1.00	1				Additional Reference
6			Streaming Data Solutions on AWS with Amazon Kinesis	https://d1.awsstatic.com/whitepapers/whitepaper-streaming-data-solutions-on-aws-with-amazon-kinesis.pdf?did=wp_card&trk=wp_card	2.00	1				Additional Reference
6			Kinesis Data Analytics - SQL Streaming Concepts	https://docs.aws.amazon.com/kinesisanalytics/latest/dev/streaming-sql-concepts.html	2.00	1				Additional Reference
6			Best Practices for Securing Amazon EMR	https://aws.amazon.com/blogs/big-data/best-practices-for-securing-amazon-emr/	1.50	1				Additional Reference
6			Reference Architecture - SQL Based Data Processing in Amazon ECS	https://d1.awsstatic.com/architecture-diagrams/ArchitectureDiagrams/sql_based_data_processing_amazon_ecs.pdf?did=wp_card&trk=wp_card	1.50	1				Additional Reference
6			Amazon DyanmoDB vs Apache Hbase for NoSQL	https://d1.awsstatic.com/whitepapers/AWS_Comparing_the_Use_of_DynamoDB_and_HBase_for_NoSQL.pdf?did=wp_card&trk=wp_card	3.00	1				Additional Reference
6			Amazon Redshift Best Practices	https://docs.amazonaws.cn/en_us/redshift/latest/dg/best-practices.html	5.00	1				
6			Complex ETL Activities using workflows in AWS Glue	https://docs.aws.amazon.com/glue/latest/dg/orchestrate-using-workflows.html	3.00	1				
6			Hands on Practice		20.00	1				
6			AWS Sample Questions	https://d1.awsstatic.com/training-and-certification/docs-data-analytics-specialty/AWS-Certified-Data-Analytics-Specialty_Sample-Questions.pdf	0.50	1				
6			AWS Exam Readiness	https://www.aws.training/Details/eLearning?id=46612	3.50	1				
6			Practice Exams	https://chercher.tech/aws-certification/aws-bds-c00-certified-big-data-speciality-practice-test-set-1	16.00	8				
6			Review Notes		20.00	1				
6			Total		94.00					

Azure-MS
R No	Job Role	Role		Self Paced Learning Path		Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	Data Engineer	Azure Data Engineer Associate		Azure fundamentals (Optional)	https://docs.microsoft.com/en-us/learn/paths/azure-fundamentals/	8:59	11				common across all the certifications
1	Implementing an Azure Data Solution	DP-200 (Required)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RWuAzL	Perform data engineering with Azure Databricks	https://docs.microsoft.com/en-us/learn/paths/data-engineering-with-databricks/	7:49	9				
1	Designing an Azure Data Solution	DP-201 (Required)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RWuAzL	Azure for the Data Engineer	https://docs.microsoft.com/en-us/learn/paths/azure-for-the-data-engineer/	1:51	3				
1	Azure Fundamentals	AZ-900 (Optional Prerequisite)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE38YZj	Implement a Data Warehouse with Azure SQL Data Warehouse	https://docs.microsoft.com/en-us/learn/paths/implement-sql-data-warehouse/	3:21	4				
1				Large Scale Data Processing with Azure Data Lake Storage Gen2	https://docs.microsoft.com/en-us/learn/paths/data-processing-with-azure-adls/	2:05	3				
1				Extract knowledge and insights from your data with Azure Databricks	https://docs.microsoft.com/en-us/learn/paths/data-science/	4:21	6				
1				Implement a Data Streaming Solution with Azure Streaming Analytics	https://docs.microsoft.com/en-us/learn/paths/implement-data-streaming-with-asa/	1:14	2				
1				Work with relational data in Azure	https://docs.microsoft.com/en-us/learn/paths/work-with-relational-data-in-azure/	3:20	4				common for data engineer and developer
1				Work with NoSQL data in Azure Cosmos DB	https://docs.microsoft.com/en-us/learn/paths/work-with-nosql-data-in-azure-cosmos-db/	5:55	8				common for data engineer and developer
1				Store data in Azure	https://docs.microsoft.com/en-us/learn/paths/store-data-in-azure/	3:50	5				common for data engineer and developer
2	DataOps Engineer	Azure DevOps Engineer Expert		Evolve your DevOps practices	https://docs.microsoft.com/en-us/learn/paths/evolve-your-devops-practices/	1:17	3				
2		AZ-400 (Required)		Build applications with Azure DevOps	https://docs.microsoft.com/en-us/learn/paths/build-applications-with-azure-devops/	6:10	7				
2				Run quality tests in your build pipeline by using Azure Pipelines	https://docs.microsoft.com/en-us/learn/modules/run-quality-tests-build-pipeline/	1:07	9				
2				Assess your existing software development process	https://docs.microsoft.com/en-us/learn/modules/assess-your-development-process/	0:17	5				
2				Scan open source components for vulnerabilities and license ratings in Azure Pipelines	https://docs.microsoft.com/en-us/learn/modules/scan-open-source/	0:27	6				
2				Create a build pipeline with Azure Pipelines	https://docs.microsoft.com/en-us/learn/modules/create-a-build-pipeline/	1:03	10				
2				Scan code for vulnerabilities in Azure Pipelines	https://docs.microsoft.com/en-us/learn/modules/scan-for-vulnerabilities/	0:53	9				
2				Manage build dependencies with Azure Artifacts	https://docs.microsoft.com/en-us/learn/modules/manage-build-dependencies/	0:39	9				
2				Implement a code workflow in your build pipeline by using Git and GitHub	https://docs.microsoft.com/en-us/learn/modules/implement-code-workflow/	1:13	10				
2				Choose an Agile approach to software development	https://docs.microsoft.com/en-us/learn/modules/choose-an-agile-approach/	0:38	5				
2				Host your own build agent in Azure Pipelines	https://docs.microsoft.com/en-us/learn/modules/host-build-agent/	0:48	7				
2				Get started with Azure DevOps	https://docs.microsoft.com/en-us/learn/modules/get-started-with-devops/	0:22	5				
2		AZ-203 (Prerequisite)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RWtQqM	Azure fundamentals (Optional)	https://docs.microsoft.com/en-us/learn/paths/azure-fundamentals/	8:59	11				common across all the certifications
2		AZ-900 (Optional Prerequisite)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE38YZj	Build applications with Azure DevOps	https://docs.microsoft.com/en-us/learn/paths/build-applications-with-azure-devops/	6:10	7				common for developer & administrator
2				Build automated workflows to integrate data and apps with Azure Logic Apps	https://docs.microsoft.com/en-us/learn/paths/build-workflows-with-logic-apps/	2:49	4				
2				Connect your services together	https://docs.microsoft.com/en-us/learn/paths/connect-your-services-together/	3:31	4				
2				Create serverless applications	https://docs.microsoft.com/en-us/learn/paths/create-serverless-applications/	6:15	7				
2				Deploy a website to Azure with Azure App Service	https://docs.microsoft.com/en-us/learn/paths/deploy-a-website-with-azure-app-service/	3:50	5				
2				Deploy a website with Azure virtual machines	https://docs.microsoft.com/en-us/learn/paths/deploy-a-website-with-azure-virtual-machines/	4:18	4				
2				Extract knowledge and insights from your data with Azure Databricks	https://docs.microsoft.com/en-us/learn/paths/data-science/	4:21	6				common for data engineer and developer
2				Introduction to machine learning with Python and Azure Notebooks	https://docs.microsoft.com/en-us/learn/paths/intro-to-ml-with-python/	2:11	3				
2				Manage resources in Azure	https://docs.microsoft.com/en-us/learn/paths/manage-resources-in-azure/	4:15	5				common for developer & administrator
2				Perform data engineering with Azure Databricks	https://docs.microsoft.com/en-us/learn/paths/data-engineering-with-databricks/	7:49	9				common for data engineer and developer
2				Secure your cloud data	https://docs.microsoft.com/en-us/learn/paths/secure-your-cloud-data/	6:45	8				common for developer & administrator
2				Work with relational data in Azure	https://docs.microsoft.com/en-us/learn/paths/work-with-relational-data-in-azure/	3:20	4				common for data engineer and developer
2				Work with NoSQL data in Azure Cosmos DB	https://docs.microsoft.com/en-us/learn/paths/work-with-nosql-data-in-azure-cosmos-db/	5:55	8				common for data engineer and developer
2		OR		Store data in Azure	https://docs.microsoft.com/en-us/learn/paths/store-data-in-azure/	3:50	5				common for data engineer and developer
2		AZ-103 (Prerequisite)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RWtY7Z	Administer containers in Azure	https://docs.microsoft.com/en-us/learn/paths/administer-containers-in-azure/	3:45	5				
2		AZ-900 (Optional Prerequisite)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE38YZj	Azure fundamentals (Optional)	https://docs.microsoft.com/en-us/learn/paths/azure-fundamentals/	8:59	11				common across all the certifications
2				Build applications with Azure DevOps	https://docs.microsoft.com/en-us/learn/paths/build-applications-with-azure-devops/	6:10	7				common for developer & administrator
2				Secure your cloud data	https://docs.microsoft.com/en-us/learn/paths/secure-your-cloud-data/	6:45	8				common for developer & administrator
2				Administer infrastructure resources in Azure	https://docs.microsoft.com/en-us/learn/paths/administer-infrastructure-resources-in-azure/	9:34	10				
2				Manage resources in Azure	https://docs.microsoft.com/en-us/learn/paths/manage-resources-in-azure/	4:15	5				common for developer & administrator
3	Solution Architect	Azure Solutions Architect Expert		Perform data engineering with Azure Databricks		0.325694444	9				
3		AZ-303 (Required)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE4psD6	Extract knowledge and insights from your data with Azure Databricks	https://docs.microsoft.com/en-us/learn/paths/data-science/	4:21	6				
3		AZ-304 (Required)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE4pCWz	Azure fundamentals (Optional)	https://docs.microsoft.com/en-us/learn/paths/azure-fundamentals/	8:59	11				common across all the certifications
3		AZ-900 (Optional Prerequisite)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE38YZj	Architect great solutions in Azure	https://docs.microsoft.com/en-us/learn/paths/architect-great-solutions-in-azure/	4:17	5				
3				Manage resources in Azure	https://docs.microsoft.com/en-us/learn/paths/manage-resources-in-azure/	4:15	5				common for developer & administrator
3				Build applications with Azure DevOps	https://docs.microsoft.com/en-us/learn/paths/build-applications-with-azure-devops/	6:10	7				

Azure-Udemy
R No	Job Role	Role		Self Paced Learning Path		Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	Data Engineer	Azure Data Engineer Associate									
1		DP-200 (Required)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RWuAzL	Azure Data Engineer Technologies for Beginner (DP-200, DP-201)	https://ibm-learning.udemy.com/course/microsoft-azure-database-and-analytics/	12:00	18				There is two separate courses as well, from the same author 
1		DP-201 (Required)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RWuAzL	Azure Data Engineer Associate Practice Exams	https://ibm-learning.udemy.com/course/azure100/	08:00	163				Reference only
1		AZ-900 (Optional Prerequisite)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE38YZj								
1											
2	DataOps Engineer	Azure DevOps Engineer Expert									
2		AZ-400 (Required)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE4wyqh	Designing and Implementing Microsoft DevOps Solutions	https://ibm-learning.udemy.com/course/azure100/	20:00	9				IBM Udemy
2				Azure DevOps Engineer Expert Practice Exams	https://chercher.tech/azure-certification/az-400-microsoft-azure-devops-solutions-practice-tests-set-1	08:00	240				
2											
3	Solution Architect	Azure Solutions Architect Expert									
3		AZ-303 (Required)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE4psD6	Azure Architecture Technologies Exam Prep 2020	https://ibm-learning.udemy.com/course/70534-azure/	11:32	22	2020-11-22	2020-12-18	Completed	IBM Udemy
				Azure Hands-on practice		23:59		2020-12-25		In Progress	
3		AZ-304 (Required)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE4pCWz	Azure Architect Design Exam Prep 2020	https://ibm-learning.udemy.com/course/az301-azure/	06:10	21				IBM Udemy
3		AZ-900 (Optional Prerequisite)	https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE38YZj	Azure Practice Exams	https://chercher.tech/azure-certification/az-300-microsoft-azure-architect-practice-exam-questions-new-set-1	12:00	16				CherCher external link

snowflake
R No	Job Role	Certification	Self Paced Learning Path		Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	SnowPro Specialist	SnowPro Core Certified								
1			Hands on Essentials	https://snowflakeuniversity.mindtickle.com/#/course/1144707017180220623	1.00	3.00	2020-06-03	2020-06-03	Completed	
1			Level Up - First Concepts	https://snowflakeuniversity.mindtickle.com/#/courses/series/1186787688786450122?series=1186787688786450122	2.00	5.00	2020-06-04	2020-06-04	Completed	
1			Level Up - Performance	https://snowflakeuniversity.mindtickle.com/#/courses/series/1224773284678453742?series=1224773284678453742	1.50	4.00	2020-06-05	2020-06-05	Completed	
1			Snowflake Advanced Capabilities	https://snowflakeuniversity.mindtickle.com/#/courses/series/1030189329649042115?series=1030189329649042115	1.50	5.00	2020-06-06	2020-06-06	Completed	
1			Snowflake Customer Onboarding	https://snowflakeuniversity.mindtickle.com/#/courses/series/1030189114109827518?series=1030189114109827518	2.00	7.00	2020-06-07	2020-06-07	Completed	
1			Snowflake Transformation	https://snowflakeuniversity.mindtickle.com/#/courses/series/1090677434802376970?series=1090677434802376970	2.00	4.00	2020-06-08	2020-06-08	Completed	
1			Snowflake Certification Information	https://snowflakeuniversity.mindtickle.com/#/courses/series/1172211196159106059?series=1172211196159106059	2.00	3.00	2020-06-09	2020-06-09	Completed	
1			Snowflake Certfication Flashcards - Quizlet	https://quizlet.com/380510774/snowflake-certification-flash-cards/	4.00	1.00	2020-06-08	2020-06-09	Completed	222 questions
										
2	SnowPro Architect	SnowPro Advanced Architect								
2			SnowPro Advanced Archite Overview	https://snowforce.my.salesforce.com/sfc/p/#i0000000hZh2/a/3r000000Pqbf/9_J6hjE0jhDFdv5uJh8fGjRVkMxnHXYveDR1McRs0lQ						
2			SnowPro Advanced Archite Study Guide	https://snowflakeuniversity.mindtickle.com/#/update/1240380887853059998?series=1172211196159106059						Link to mindtickle. Need an account to access the guide
2			Snowflake - Architect Preparation Exams	https://www.udemy.com/course/snowflake-certification-preparation-g/	8.00	5.00				Check for other exam questions as well on the internet
2		Snowflake Company Overview	Snowflake Website	https://www.snowflake.com/	0.02					Skip if you are a SnowPro
2			About Snowflake	https://www.snowflake.com/company/	0.02					Skip if you are a SnowPro
2			Meet the Two Guys Who Built the #1 Cloud Data Platform	https://www.youtube.com/watch?v=Y05ZNHwvfsg&list=PL4IM5KTx_T7hqGNkqv-_LqHKffOb8H8y1	0.02					Skip if you are a SnowPro
2			Reinventing the Data Warehouse (Video)	https://www.youtube.com/watch?v=Y05ZNHwvfsg&list=PL4IM5KTx_T7hqGNkqv-_LqHKffOb8H8y1	0.02					Skip if you are a SnowPro
2			Introduction to Snowflake Cloud Data Platform (Video) 	https://snowflakeuniversity.mindtickle.com/#/update/1261002509048556246?series=1186787688786450122	0.03					Skip if you are a SnowPro
2			Snowflake University, LevelUp: Snowflake’s Key Concepts	https://snowflakeuniversity.mindtickle.com/#/update/1187475440690432307?series=1186787688786450122	0.10					Skip if you are a SnowPro
2		How Snowflake is Different	Introduction to Snowflake - Key Concepts & Architecture	https://docs.snowflake.com/en/user-guide/intro-key-concepts.html	0.15					Skip if you are a SnowPro
2			Snowflake Getting Started Documentation	https://docs.snowflake.com/en/user-guide-getting-started.html	0.30					Skip if you are a SnowPro
2			Getting Started with Snowflake - Key Concepts (Video)	https://www.youtube.com/watch?v=dZlBCLLL7UA	0.07					Skip if you are a SnowPro
2			Before You Begin	https://docs.snowflake.com/en/user-guide/setup.html	0.05					Skip if you are a SnowPro
2			See Snowflake in 8 Minutes (Video)	https://www.youtube.com/watch?v=JSYumKAF2Lc	0.09					Skip if you are a SnowPro
2		Snowflake Editions & Deployments	Snowflake University, LevelUp: Snowflake Account Options & Assurances	https://snowflakeuniversity.mindtickle.com/#/update/1192528624267286058?series=1186787688786450122	0.30					
2			Technology Partners - AWS	https://www.snowflake.com/technology-partners/amazon-web-services/	0.15					
2			Technology Partners  - Azure	https://www.snowflake.com/technology-partners/microsoft/	0.15					
2			Technology Partners  - GCP	https://www.snowflake.com/technology-partners/google-cloud-platform/	0.15					
2			Snowflake Regions	https://docs.snowflake.com/en/user-guide/intro-regions.html	0.20					
2			Snowflake Editions	https://docs.snowflake.com/en/user-guide/intro-editions.html	0.30					
2		Key Features	Overview of Key Features	https://docs.snowflake.com/en/user-guide/intro-supported-features.html	0.60					
2			Introduction to Semi Structured Data	https://docs.snowflake.com/en/user-guide/semistructured-intro.html	0.45					
2			Bringing Together Structured and Semi Structured Data	https://www.youtube.com/watch?v=MdLxEzYmJyI&feature=youtu.be	0.05					
2			Semi-Structured Data Types	https://docs.snowflake.com/en/sql-reference/data-types-semistructured.html	0.15					
2			Querying Semi-Structured Data	https://docs.snowflake.com/en/user-guide/querying-semistructured.html	0.60					
2			Continuous Data Protection	https://docs.snowflake.com/en/user-guide/data-cdp.html	0.15					
2			Snowflake Fast Clone	https://www.snowflake.com/blog/snowflake-fast-clone/	0.15					
2			A Quick Look at Zero Copy Cloning	https://www.youtube.com/watch?v=yQIMmXg7Seg	0.05					
2			Cloning in Snowflake (Video)	https://www.youtube.com/watch?v=SdHEMTQOcCQ	0.20					
2			Using Persisted Query Results	https://docs.snowflake.com/en/user-guide/querying-persisted-results.html	0.15					
2			Accelerating BI Queries with Caching in Snowflake (Video)	https://www.youtube.com/watch?v=lcO8CRT5EMc&feature=youtu.be	0.05					
2			Top 10 Cool Snowflake Features, #10: Snowflake Query Result Sets Available to Users via History	https://www.snowflake.com/blog/snowflake-query-result-sets-available-to-users-via-history/	0.15					
2			Sharing Data in Snowflake	https://docs.snowflake.com/en/user-guide-data-share.html	0.15					
2		Snowflake Pricing & Editions	Snowflake Editions & Pricing 	https://www.snowflake.com/pricing/	0.15					
2			Snowflake Regions	https://docs.snowflake.com/en/user-guide/intro-regions.html	0.20					
2		Snowflake Architecture	Database Storage	https://docs.snowflake.com/en/user-guide/intro-key-concepts.html#database-storage	0.10					Skip if you are a SnowPro
2			Query Processing	https://docs.snowflake.com/en/user-guide/intro-key-concepts.html#query-processing	0.10					Skip if you are a SnowPro
2			Cloud Services	https://docs.snowflake.com/en/user-guide/intro-key-concepts.html#cloud-services	0.05					Skip if you are a SnowPro
2			Snowflake University, LevelUp: Snowflake’s Three Layer Design(Document + Quiz) 	https://snowflakeuniversity.mindtickle.com/#/update/1187839585467233496?series=1186787688786450122		0.20				Additional Resources: Redundant. Try the quiz
2			Snowflake Architecture, Cloud Services (Video)	https://snowflakeuniversity.mindtickle.com/#/course/1053014747151500422		0.05				Additional Resources: Retired. Redundant Content
2			FundamentalData Warehouse Architecture (Paper)	https://resources.snowflake.com/snowflake-product/fundamental-data-warehouse-architecture-guide		0.45				Additional Resources: Skip if you are familiar with DW
2		Interfaces & Connectivity	Snowflake Web Interface (UI)	https://docs.snowflake.com/en/user-guide/connecting.html	0.30					To install SnowSQL and test connection
2			SnowSQL (CLI)	https://docs.snowflake.com/en/user-guide/snowsql-use.html	0.90					
2			Connector Ecosystem	https://docs.snowflake.com/en/user-guide-connecting.html	1.20					
2			Partner Connector Ecosystem	https://docs.snowflake.com/en/user-guide/ecosystem.html	0.20					
2		Exercise - HOLG	Module 1: Prepare your Lab Environment	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf	0.15					Module 1 only. Skip if you already have an account
2		Exercise - HOLG	Module 2: The Snowflake User Interface & Lab “Story” 	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf	0.15					Module  2 only. Skip if you already familiar with Web UI
2			Quick Tour of the Web Interface(Document + Video) 	https://docs.snowflake.com/en/user-guide/snowflake-manager.html		0.15				Additional Resources: Skip if you are already familiar
2			User Interface Quick Tour(Video) 	https://www.youtube.com/watch?v=8vDqf1Nd0Hk&feature=youtu.be		0.05				Additional Resources: Skip if you are already familiar
2			Snowflake University, Hands on Web UI Essentials (Video, Labs + Project work)	https://snowflakeuniversity.mindtickle.com/#/1144707017180220623		1.50				Additional Resources: Skip if you are already familiar
2			Snowflake University, Level Up: Snowflake Ecosystem (Document + quiz) 	https://snowflakeuniversity.mindtickle.com/#/update/1194386458901462596?series=1186787688786450122		1.20				Additional Resources: Skip if you are already familiar
2			Snowflake University, Snowflake User Interface Walkthrough(Video) 	https://snowflakeuniversity.mindtickle.com/#/1031695982682370150		0.30				Additional Resources: Retired
2			Snowflake University, Snowflake Clients and Ecosystem (Video)	https://snowflakeuniversity.mindtickle.com/#/1049461280639111275		0.30				Additional Resources: Retired
2			Getting Started on Snowflake with Partner Connect(Video)	https://www.youtube.com/watch?v=8sO53KczJ4M&feature=youtu.be		0.06				Additional Resources:
2		Catalog & Objects	Database & Schema	https://docs.snowflake.com/en/user-guide/databases.html	1.20					
2			Tables	https://docs.snowflake.com/en/user-guide/table-considerations.html	1.20					
2			Views	https://docs.snowflake.com/en/user-guide/views-introduction.html	1.20					
2			Data Types	https://docs.snowflake.com/en/sql-reference/data-types.html	1.20					
2		Data Sharing	Sharing Configuration & Access Control options	https://docs.snowflake.com/en/user-guide/data-sharing-secure-views.html	0.60					
2			Secure Data Sharing	https://docs.snowflake.com/en/user-guide/data-sharing-intro.html	0.30					
2			Providers, Consumers & Reader Accounts	https://docs.snowflake.com/en/user-guide/data-sharing-intro.html	0.15					
2			Creating & Managing Shares	https://docs.snowflake.com/en/user-guide/data-sharing-gs.html	0.15					
2		Exercise - HOLG	Module 9: Data Sharing	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf	0.45					
2			Data Sharing for Dummies(eBook)	https://resources.snowflake.com/ebooks/data-sharing-for-dummies		2.40				Additional Resources: Ebook 68 pages
2			Snowflake University, Data Sharing in Snowflake (Video)	https://snowflakeuniversity.mindtickle.com/#/1077977889065634691		0.60				Additional Resources: Retired Conent
2			Snowflake University, Hands-On Sharing, Marketplace, & Exchanges Workshop (Video, Labs + Project work)	https://snowflakeuniversity.mindtickle.com/#/programs/program/1233456049634814937		3.00				Additional Resources: Badge workshop 2
2		Virtual Warehouses - Compute	Warehouses & Types	https://docs.snowflake.com/en/user-guide/warehouses-overview.html	0.15					
2			Warehouse Sizing & Scaling	https://docs.snowflake.com/en/user-guide/warehouses-considerations.html	0.15					
2			Credit Usage	https://docs.snowflake.com/en/user-guide/warehouses-considerations.html	0.15					
2			Warehouse Management	https://docs.snowflake.com/en/user-guide/warehouses-considerations.html	0.15					
2			Warehouse Caching	https://docs.snowflake.com/en/user-guide/warehouses-considerations.html#how-does-warehouse-caching-impact-queries	0.10					
2			Warehouse Monitoring	https://docs.snowflake.com/en/user-guide/warehouses-load-monitoring.html	0.20					
2			Tackling High Concurrency with Multi-Cluster Warehouses (Video)	https://www.youtube.com/watch?v=6TLnlDTDFBo&feature=youtu.be		0.05				Additional Resources: 
2			Snowflake University, LevelUp: Query & Result(Video + Quiz)	https://snowflakeuniversity.mindtickle.com/#/update/1196921826353350685?series=1224773284678453742		0.30				Additional Resources: LevelUp, Revise once
2		Storage and Protection - Storage	Micro partitions	https://docs.snowflake.com/en/user-guide/tables-clustering-micropartitions.html	0.45					
2			Metadata	https://docs.snowflake.com/en/user-guide/tables-clustering-micropartitions.html	0.15					
2			Clustering	https://docs.snowflake.com/en/user-guide/tables-clustering-keys.html	1.20					
2			Data Storages –Cost & Retention	https://docs.snowflake.com/en/user-guide/credits.html	0.45					
2			Table Types, File Formats	https://docs.snowflake.com/en/user-guide/databases.html	0.45					Covered under catalog & objects, key features
2			Storage Monitoring	https://docs.snowflake.com/en/user-guide/tables-storage-considerations.html	0.15					
2			Meta Data Archiving with Snowflake (Blog) 	https://community.snowflake.com/s/article/Metadata-Archiving-with-Snowflake		0.30				Additional Resources:
2			Snowflake University, Level Up: Container Hierarchy(Document + quiz) 	https://snowflakeuniversity.mindtickle.com/#/update/1194386458901462596?series=1186787688786450122		0.60				Additional Resources:
2			Top 10 Cool Snowflake Features, #7: Snowflake Fast Clone(Blog + video)	https://snowflakeuniversity.mindtickle.com/#/update/1194386458901462596?series=1186787688786450122		0.30				Additional Resources:
2		Storage and Protection - Continuous Data Protection	Time Travel, Fail Safe	https://docs.snowflake.com/en/user-guide/data-availability.html	0.90					
2			Data Encryption	https://docs.snowflake.com/en/user-guide/security-encryption.html	0.60					
2			Security –Network policies	https://docs.snowflake.com/en/user-guide/network-policies.html	0.90					
2			Multi-Factor Authentication (MFA)	https://docs.snowflake.com/en/user-guide/security-mfa.html	0.60					
2			Federated Authentication & SSO	https://docs.snowflake.com/en/user-guide/admin-security-fed-auth.html	1.80					
2		Exercise - HOLG	Module 7: Using Time Travel	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf		0.30				
2			Snowflake Continuous Data Protection (White Paper) 	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf		0.45				Additional Resources:
2			Snowflake University, Snowflake Backup & Recover (Video)	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf		0.60				Additional Resources: Access level is restricted
2		Data Movement - Data Loading	Stages, file format, pipe	https://docs.snowflake.com/en/user-guide/intro-summary-loading.html	0.45					
2			Bulk Load using COPY	https://docs.snowflake.com/en/user-guide/data-load-overview.html#overview-of-data-loading	0.20					
2			Loading Consideration & Load Management	https://docs.snowflake.com/en/user-guide/data-load-considerations-load.html	0.30					
2			Continuous Load Options –Snowpipe	https://docs.snowflake.com/en/user-guide/data-load-overview.html#continuous-loading-using-snowpipe	0.30					
2			Error handling & Troubleshooting	https://docs.snowflake.com/en/user-guide/data-load-bulk-ts.html#troubleshooting-bulk-data-loads	0.30					
2		Exercise - HOLG	Module 3: Preparing to Load Data 	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf	0.30					
2		Exercise - HOLG	Module 4: Loading Data 	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf	0.45					
2			Getting Started -Introduction to Databases and Querying(Video)	https://www.youtube.com/watch?v=i4zify54Vys&feature=youtu.be		0.06				Additional Resources:
2			How to Load Terabytes intoSnowflake -Speeds, Feeds and Techniques(Blog) 	https://www.snowflake.com/blog/how-to-load-terabytes-into-snowflake-speeds-feeds-and-techniques/		0.30				Additional Resources:
2			Snowflake University, Snowflake Data Loading Best Practices (Video)	https://snowflakeuniversity.mindtickle.com/#/1044417980398058228		0.90				Additional Resources: Retired Content
2		Data movement - Data Unloading	Unloading data from Snowflake to External Cloud Storage (S3,GCS,AZURE BLOB)	https://docs.snowflake.com/en/user-guide-data-unload.html	1.20					
2			Unloading data from Snowflake to Internal Snowflake Storage	https://docs.snowflake.com/en/user-guide-data-unload.html	0.30					
2			Unloading data from Snowflake to Local / Network Drive 	https://docs.snowflake.com/en/user-guide/data-unload-considerations.html	0.15					Pointing to data unloading consideration!! Wrong link?
2			Data Unloading Considerations	https://docs.snowflake.com/en/user-guide/data-unload-considerations.html	0.30					
2		Snowflake Connector for Kafka	Schema of Topics for Kafka Topics	https://docs.snowflake.com/en/user-guide/kafka-connector-overview.html#schema-of-topics-for-kafka-topics	0.45					
2			Workflow for the Kafka Connector	https://docs.snowflake.com/en/user-guide/kafka-connector-overview.html#workflow-for-the-kafka-connector	0.30					
2		Semi Structured Data	Different Formats, Variant Table Type 	https://docs.snowflake.com/en/user-guide/semistructured-intro.html	0.30					
2			Native Syntax, Flattening DATA	https://docs.snowflake.com/en/user-guide/table-considerations.html	0.15					
2		Exercise - HOLG	Module 6: Working with Semi-Structured Data	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf	0.90					
2			Best Practices for Using Tableau with Snowflake (White Paper)	https://resources.snowflake.com/ebooks/best-practices-for-using-tableau-with-snowflake		3.00				Additional Resources: 63 pages. Skip it
2			Easily Loading and Analyzing Semi-Structured Data in Snowflake (Video)	https://www.youtube.com/embed/H0sbMDqdYQ8?list=PL4IM5KTx_T7hBvbHgLKEqWp75CumkicJI		0.05				Additional Resources:
		Performance & Tuning - Performance Management	Query Performance & Analysis 	https://www.youtube.com/embed/H0sbMDqdYQ8?list=PL4IM5KTx_T7hBvbHgLKEqWp75CumkicJI	1.20					
			SQL optimization							No link provided
			Load Testing							No link provided
			Clustering & Materialized Views 	https://docs.snowflake.com/en/user-guide/views-materialized.html	1.80					
			Query Profile	https://docs.snowflake.com/en/user-guide/ui-query-profile.html	1.20					
			Caching							No link provided. Already covered in LevelUP
			Using Materialized Views to Solve Multi-Clustering Performance Problems Snowflake University, Level Up: 	https://community.snowflake.com/s/article/USING-MATERIALIZED-VIEWS-TO-SOLVE-MULTI-CLUSTERING-PERFORMANCE-PROBLEMS		0.45				Additional Resources:
			Caching (Video + Quiz)	https://snowflakeuniversity.mindtickle.com/#/update/1204542405542165581?series=1224773284678453742		0.45				Additional Resources: Practice this lab
			Snowflake University, SQL Support and Usage in Snowflake (Video)	https://snowflakeuniversity.mindtickle.com/#/1077983095837588346		0.90				Additional Resources: Retired Content.
		Account & Security - Account Management	Managing Your Snowflake Account 	https://docs.snowflake.com/en/user-guide-admin.html	0.90					
			WAREHOUSE & Storage credit usage 	https://docs.snowflake.com/en/sql-reference/account-usage.html	0.45					
			Materialized Views	https://docs.snowflake.com/en/sql-reference/account-usage/materialized_view_refresh_history.html	0.15					
			Auto /Re Clustering	https://docs.snowflake.com/en/sql-reference/account-usage/automatic_clustering_history.html	0.15					
			DR & Replication	https://docs.snowflake.com/en/sql-reference/account-usage/replication_usage_history.html	0.15					
			Information Schema	https://docs.snowflake.com/en/sql-reference/info-schema.html	0.45					
			Differences Between Account Usage and Information Schema	https://docs.snowflake.com/en/sql-reference/account-usage.html	0.15					
		Exercise - HOLG	Module 8: Role Based Access Controls and Account Admin	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf	0.60					
			Snowflake Community Administering Snowflake Guide 	https://community.snowflake.com/s/snowflake-administration		0.60				Additional Resources: Useful cheatsheets
			Snowflake University, Snowflake Administration Overview	https://snowflakeuniversity.mindtickle.com/#/1040279688117913424		1.20				Additional Resources: Retired Content
		Security	Access Control	https://docs.snowflake.com/en/user-guide/security-access-control.html	0.60					
			Role Hierarchy and Privilege Inheritance 	https://docs.snowflake.com/en/user-guide/security-access-control-overview.html#role-hierarchy-and-privilege-inheritance	0.30					
			Multi-Factor Authentication (MFA) 	https://docs.snowflake.com/en/user-guide/security-mfa.html	0.30					
			Data Encryption	https://docs.snowflake.com/en/user-guide/security-encryption.html	0.90					
			Network Security & Policies	https://docs.snowflake.com/en/user-guide/network-policies.html	0.90					
			Federated Authentication & SSO	https://docs.snowflake.com/en/user-guide/admin-security-fed-auth.html	1.80					
			Snowflake Editions	https://docs.snowflake.com/en/user-guide/intro-editions.html	0.30					Already covered in previous sections
		Exercise - HOLG	Module 8: Role Based Access Controls and Account Admin	https://s3.amazonaws.com/snowflake-workshop-lab/Snowflake_free_trial_LabGuide.pdf	1.20					
			Snowflake Security Overview (Video)	https://www.youtube.com/watch?v=Qzge2Mt84rs&feature=youtu.be	0.05					Additional Resources:
			Data Protection with Time Travel in Snowflake (Video)	https://www.youtube.com/embed/F1pevMhm7lg?list=PL4IM5KTx_T7hBvbHgLKEqWp75CumkicJI	0.05					Additional Resources:
			Crucial Security Controls for Your Cloud Data Warehouse (Video) 	https://www.youtube.com/watch?v=vv72f8PRXWE&feature=youtu.be	0.05					Additional Resources:
			Snowflake University, Snowflake Security Overview (Video)	https://snowflakeuniversity.mindtickle.com/#/1030984830208164453	0.60					Additional Resources: Retired Content
										
			Total Estimated Time		74.00	35.00				

Kafka
R No	Job Role	Certification	Self Paced Learning Path		Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	Kafka Developer	Confluent Certified Kafka Developer	Apache Kafka Fundamentals	https://www.udemy.com/share/1013hcAEsSdlhSTXo=/	7.50	123				
1			Kafka Connect	https://www.udemy.com/share/101Yx6AEsSdlhSTXo=/	4.50	55				
1			Kafka Streams for Data Processing	https://www.udemy.com/share/101YreAEsSdlhSTXo=/	4.75	76				
1			Confluent Schema Registry and REST Proxy		4.30	58				
1			Confluent KSQL	https://www.udemy.com/share/10208mAEsSdlhSTXo=/	3.75	36				
1			Kafka Cluster Setup And Administration	https://www.udemy.com/share/101YfKAEsSdlhSTXo=/	4.00	48				
1			Kafka Security	https://www.udemy.com/share/101XAcAEsSdlhSTXo=/	4.00	43				Not a exam topic
1			Practice Exams	https://www.udemy.com/share/1021QoAEsSdlhSTXo=/	12.00	3				150 questions in total
			Total		44.80					

Ansible
R No	Job Role	Certification	Self Paced Learning Path		Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	Configuration Engineer	Red Hat Certified Specialist in Advanced Automation: Ansible Best Practices	Ansible Certification - Red Hat EX447	https://www.redhat.com/en/services/certification/red-hat-certified-specialist-advanced-automation-ansible-best-practices	0.50	1				
1			Exam details	https://www.redhat.com/en/services/certification/red-hat-certified-specialist-advanced-automation-ansible-best-practices	0.25	1				
1			Yourlearning - Ansible Automation	https://yourlearning.ibm.com/activity/SAFARI-9781800206496	17.50	25				

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
