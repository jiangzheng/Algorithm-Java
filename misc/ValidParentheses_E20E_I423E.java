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



R No	Job Role	Certification	Self Paced Learning Path	Module Duration	# of Modules	Start Date	End Date	Status	Comments
1	Data Engineer	AWS Certified Cloud Practitioner							
1		For udemy course, use ibm udemy link	https://www.udemy.com/course/aws-certified-cloud-practitioner-training-course/	12.00	171	2020-03-26	2020-03-29	Completed	Udemy
1		for the same course using ibm link	https://d0.awsstatic.com/whitepapers/aws-overview.pdf	6.00	1	2020-03-29	2020-03-30	Completed	aws services overview, 94 pages, 
1		https://ibm-learning.udemy.com/	https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf	4.00	1	2020-03-30	2020-03-31	Completed	aws well-architected framework, 76 pages
1			http://d1.awsstatic.com/whitepapers/aws_pricing_overview.pdf	1.00	1	2020-04-01	2020-04-01	Completed	aws pricing, 21 pages
1			Practice exams	4.00	2	2020-03-29	2020-03-31	Completed	Available as part of Udemy course
1			Hands on practice	13.00	1	2020-03-26	2020-03-29	Completed	On aws cloud, using free services
1			Total	40.00					Add additional 10 hours if needed
2	Solution Architect	AWS Solutions Architect Associate							
2			https://www.udemy.com/course/aws-certified-solutions-architect-associate-saa-c02/	23.50	284				Preferred course
2		or	https://www.udemy.com/course/aws-certified-solutions-architect-associate/	24.00	107	2020-04-18	2020-05-26	Completed	
2			https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf	4.00	1	2020-05-26	2020-05-27	Completed	aws well-architected framework, 76 pages
2		For udemy course, use ibm udemy link	https://d0.awsstatic.com/whitepapers/AWS%20Storage%20Services%20Whitepaper-v9.pdf	2.00	1	2020-05-29	2020-05-29	Completed	aws storage services, 44 pages
2		for the same course using ibm link	https://d0.awsstatic.com/whitepapers/aws-security-best-practices.pdf	6.00	1	2020-05-30	2020-05-31	Completed	aws security best practices, 73 pages
2		https://ibm-learning.udemy.com/	Practice exams	18.00	4	2020-05-26	2020-06-03	Completed	
2			Hands on practice	24.00	1	2020-04-19	2020-05-26	Completed	On aws cloud, using free services
2			Review notes	6.00	1	2020-06-01	2020-06-02	Completed	
2			Total	84.00					Add additinoal 10 hours if needed
6	Data Engineer	AWS Developer Associate							
6			https://www.udemy.com/course/aws-certified-developer-associate-dva-c01/	19.00	221				
		For udemy course, use ibm udemy link	https://www.udemy.com/course/aws-certified-developer-associate/	15.50	127	2020-06-09	2020-06-23	Completed	
6		for the same course using ibm link	https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf	4.00	1	2020-06-24	2020-06-24	Completed	aws well-architected framework, 76 pages
6		https://ibm-learning.udemy.com/	https://d1.awsstatic.com/whitepapers/aws-security-whitepaper.pdf	6.00	1			Skipped	aws security, 88 pages
6			https://d0.awsstatic.com/whitepapers/aws-security-best-practices.pdf	6.00	1	2020-06-25	2020-06-25	Completed	aws security best practices, 73 pages
6			https://d1.awsstatic.com/whitepapers/microservices-on-aws.pdf	2.00	1	2020-06-26	2020-06-26	Completed	microservics on aws, 29 pages
6			https://d0.awsstatic.com/whitepapers/compliance/Intro_to_Security_by_Design.pdf	1.50	1	2020-06-26	2020-06-26	Completed	aws security by design, 14 pages
6			https://d0.awsstatic.com/whitepapers/DevOps/practicing-continuous-integration-continuous-delivery-on-AWS.pdf	3.00	1	2020-06-24	2020-06-25	Completed	CI/CD delivery on aws, 30 pages
6			https://d1.awsstatic.com/whitepapers/AWS_Blue_Green_Deployments.pdf	3.00	1	2020-06-27	2020-06-27	Completed	aws blue green deployment, 35 pages
6			https://d1.awsstatic.com/whitepapers/DevOps/running-containerized-microservices-on-aws.pdf	2.00	1	2020-06-28	2020-06-28	Completed	running containerized on aws, 18 pages
6			https://d1.awsstatic.com/whitepapers/serverless-architectures-with-aws-lambda.pdf	6.00	1	2020-06-28	2020-06-29	Completed	aws lambda, 43 pages
6			Practice exams	12.00	4	2020-06-26	2020-06-29	Completed	
6			Hands on practice	16.00	1	2020-06-09	2020-06-23	Completed	
6			Review notes	10.00	1	2020-06-29	2020-06-30	Completed	
6			Total	87.00					Add additional 10 hours if needed
4	Security Specialist	AWS SysOps Administrator Associate							
4			https://www.udemy.com/course/ultimate-aws-certified-sysops-administrator-associate/	19.50	236	2020-06-30		In Progress	On hold due to kafka certification
4		For udemy course, use ibm udemy link	https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf	3.00	1				aws kms best practices, 24 pages
4		for the same course using ibm link	https://d0.awsstatic.com/whitepapers/Security/AWS_Security_Best_Practices.pdf?refid=em_	3.00	1				GDPR compliance on aws, 34 pages
4		https://ibm-learning.udemy.com/	http://d0.awsstatic.com/whitepapers/Security/AWS%20Security%20Whitepaper.pdf	6.00	1				aws security, 88 pages
4			https://d0.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf	1.50	1				aws key compliance questions, 8 pages
4			https://media.amazonwebservices.com/AWS_Development_Test_Environments.pdf	6.00	1				aws compliance quick reference, 58 pages
			https://d0.awsstatic.com/whitepapers/Backup_Archive_and_Restore_Approaches_Using_AWS.pdf	3.00					
			https://media.amazonwebservices.com/AWS_Amazon_VPC_Connectivity_Options.pdf	1.50					
4			http://d0.awsstatic.com/whitepapers/aws_pricing_overview.pdf	1.50	1				aws security by design, 14 pages
4			Practice exams	12.00	4				
4			Hands on practice	24.00	1				
4			Review notes	4.00	1				
4			Total	85.00					Add additional 20 hours if needed
3	DevOps Engineer	AWS DevOps Engineer Professional							
3			https://www.udemy.com/course/aws-certified-devops-engineer-professional-hands-on/	20.50	224				
3		For udemy course, use ibm udemy link	https://d0.awsstatic.com/whitepapers/DevOps/infrastructure-as-code.pdf	3.00	1				aws infrastructure as code, 30 pages
3		for the same course using ibm link	https://d1.awsstatic.com/whitepapers/microservices-on-aws.pdf	2.00	1				microservics on aws, 29 pages
3		https://ibm-learning.udemy.com/	https://d0.awsstatic.com/whitepapers/AWS_DevOps.pdf	2.00	1				devops on aws, 20 pages
3			https://d1.awsstatic.com/whitepapers/DevOps/Jenkins_on_AWS.pdf	4.00	1				jenkins on aws, 44 pages
3			https://media.amazonwebservices.com/AWS_Development_Test_Environments.pdf	2.00	1				development and test on aws, 17 pages
3			https://d1.awsstatic.com/whitepapers/DevOps/running-containerized-microservices-on-aws.pdf	2.00	1				running containerized on aws, 18 pages
3			https://d1.awsstatic.com/whitepapers/AWS_Blue_Green_Deployments.pdf	3.00	1				aws blue green deployment, 35 pages
3			https://d0.awsstatic.com/whitepapers/DevOps/practicing-continuous-integration-continuous-delivery-on-AWS.pdf	3.00	1				CI/CD delivery on aws, 30 pages
3			https://d1.awsstatic.com/whitepapers/DevOps/import-windows-server-to-amazon-ec2.pdf	2.00	1				powershell on aws, 16 pages
3			Practice exams	12.00	4				
3			Hands on practice	24.00	1				
3			Review notes	10.00	1				
3			Total	100.00					Add additional 20 hours if needed
5	Solution Architect	AWS Solutions Architect Professional							
5			https://www.udemy.com/course/aws-solutions-architect-professional/	13.00	132				
5		For udemy course, use ibm udemy link	https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf	4.00	1				aws well-architected framework, 76 pages
5		for the same course using ibm link	https://d1.awsstatic.com/whitepapers/aws-security-whitepaper.pdf	6.00	1				aws security, 88 pages
5		https://ibm-learning.udemy.com/	https://d0.awsstatic.com/whitepapers/aws-security-best-practices.pdf	6.00	1				aws security best practices, 73 pages
5			https://d1.awsstatic.com/whitepapers/microservices-on-aws.pdf	2.00	1				microservics on aws, 29 pages
5			https://d0.awsstatic.com/whitepapers/compliance/Intro_to_Security_by_Design.pdf	1.30	1				aws security by design, 14 pages
5			https://d0.awsstatic.com/whitepapers/DevOps/practicing-continuous-integration-continuous-delivery-on-AWS.pdf	3.00	1				CI/CD delivery on aws, 30 pages
5			https://d0.awsstatic.com/whitepapers/Backup_and_Recovery_Approaches_Using_AWS.pdf	3.00	1				BandR, pages 26
5			https://d1.awsstatic.com/whitepapers/aws-disaster-recovery.121b65092f931567af5370b47dd12cb18866089c.pdf	3.00	1				disaster and recovery, pages 22
5			Practice exams	12.00	4				
5			Hands on practice	56.50	1				
5			Review notes	10.00	1				
5			Total	120.00					Add additional 20 hours if needed
6	Big Data Engineer	AWS Certified Data Analytics - Speciality	AWS Certification Page Link						
6		AWS DAS-C01	Exam Guide	0.50	1				
6		Exam Duration - 170 minutes 65 Qs	https://ibm-learning.udemy.com/course/aws-big-data/	12.50	12				
6			Big Data Options on AWS	2.00	1				Additional Reference
6			Lamda Architecture for Batch and Stream Processing	1.00	1				Additional Reference
6			Streaming Data Solutions on AWS with Amazon Kinesis	2.00	1				Additional Reference
6			Kinesis Data Analytics - SQL Streaming Concepts	2.00	1				Additional Reference
6			Best Practices for Securing Amazon EMR	1.50	1				Additional Reference
6			Reference Architecture - SQL Based Data Processing in Amazon ECS	1.50	1				Additional Reference
6			Amazon DyanmoDB vs Apache Hbase for NoSQL	3.00	1				Additional Reference
6			Amazon Redshift Best Practices	5.00	1				
6			Complex ETL Activities using workflows in AWS Glue	3.00	1				
6			Hands on Practice	20.00	1				
6			AWS Sample Questions	0.50	1				
6			AWS Exam Readiness	3.50	1				
6			Practice Exams	16.00	8				
6			Review Notes	20.00	1				
6			Total	94.00					
