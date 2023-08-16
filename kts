
 Knowledge Transfer
< Solving S3 Event Notification Error >

									        By Kashif Quadri
										  16/08/2023

**Challenge :**
Hey Geeks, while I was setting event notifications I got a error which says 'Unable to validate the following destination configurations' ?? Can you troubleshoot and overcome the error , Put your problem-solving skills to the test and conquer this challenge!"
==============================================================================
**Task :**
Ticket: Solve the configuration error and make the Event notification work.
==============================================================================
**Solution :**
"Challenge Conquered! To overcome I have made a json script in access policy section in SNS topic which have been worked and the event notification is ready for run.
==============================================================================
**Pre-requisites:**
•	Have a good knowledge about Json files
•	Knowing the knowledge about Event Notification
•	Have knowledge about SNS 
==============================================================================


**Objective:**
The objective is to solve the configuration error and make the email notification work…
==============================================================================
**Description:**
The error message "Unable to validate the following destination configurations" typically signifies an issue encountered during the process of verifying and confirming the accuracy of specified configuration settings for a particular system, service, or software. This error commonly emerges when attempting to establish communication or integrate different components, such as APIs, endpoints, or services. It indicates that the provided settings might contain inaccuracies, missing details, or permission-related problems, which hinder the successful validation of the intended configuration. Addressing this error involves meticulous review of configuration parameters, ensuring proper permissions, confirming network connectivity, and troubleshooting any potential obstacles that obstruct the validation process. Through careful investigation and rectification of configuration discrepancies, this error can be resolved, enabling seamless interactions and operations between interconnected elements.
 ==============================================================================
**Steps:**
# Here we are going to solve the Event Configuration error which occurred when we were setting the Event notifications.
# To overcome this error we are going to enter some details in SNS topic so follow the steps…
Step 1 ( Setting up Access policy )
# Go to your SNS topic and open it
	After opening the SNS topic click on edit
	Scroll down you will see access policy click on it 
# Here we are going to enter a JSON script to make it work 
# Amazon AWS has provided some sample example of JSON script which you can use it 
Link : https://docs.aws.amazon.com/AmazonS3/latest/userguide/ways-to-add-notification-config-to-bucket.html 
# Down I have provided a sample script…

JSON Script :::::
{
  "Version": "2012-10-17",
  "Id": "mynotifications",
  "Statement": [
    {
      "Sid": "",
      "Effect": "Allow",
      "Principal": {
        "Service": "s3.amazonaws.com"
      },
      "Action": "SNS:Publish",
      "Resource": "arn:aws:sns:eu-west-3:553153436248:mynotifications",
      "Condition": {
        "ArnLike": {
          "aws:SourceArn": "arn:aws:s3:::mybluwbhalebucket"
        }
      }
    }
  ]
}

# Replace the Bold Items with your SNS Details
# Replace ID – with your SNS name
# Replace resource – with your bucket ARN ID
# Replace aws:sourceArn – with you bucket name
# After changing paste it in access policy section and save it

Step 5 ( Adding Element to check )
# In this part we will again have to upload some files to check whether the event notification is working properly or not…
# You can upload the Free-CSS files for practice which you have downloaded before…	

	Firstly click on your bucket and open it
	Then go to objects tab
	Then click on upload
	In flies and folder section click on add files
	Then drag the files and folders in the files section
	Now click Upload
# After the uploading is done check the email id you will receive the notification about uploading the file…
# By these you will receive all the notification on email for what services you have selected…

#### This is the conclusion for Event Notification ####
==============================================================================
**Explanation:**
S3 event notifications using an SNS (Simple Notification Service) topic provide a straightforward way to receive alerts about events occurring within an S3 bucket, all without the need for AWS Lambda. When an event, like an object upload or deletion, occurs in the specified S3 bucket, the configured S3 event notification triggers a message to be sent to the associated SNS topic.
Subscribers to the SNS topic can include various endpoints like email addresses, SMS numbers, or HTTP/HTTPS URLs. These subscribers will receive notifications directly from the SNS topic whenever the corresponding events take place in the S3 bucket. This mechanism enables real-time communication and automation without requiring the additional complexity of Lambda functions.
This approach is ideal for scenarios where you only need to be informed about events and don't require additional processing or logic beyond sending notifications. It offers a lightweight solution for staying updated on S3 events while streamlining the architecture.
