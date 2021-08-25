# Introduction to SAML
Reference : https://www.okta.com/blog/2020/09/what-is-saml/

SAML stands for Security Assertion Markup Language, an open standard that passes authorization credentials from identity providers (IdPs) to service providers (SPs). Put simply, it enables secure communication between applications and allows users to gain access with a single set of credentials.

## Actors in SAML
In order for SAML to work, there needs to be an identity provider and a service provider: 
* __Identity providers (IDP) authenticate users:__  These systems are responsible for confirming that a user is who they say are, and then sending that data (and the user’s access rights) to a service provider. Okta, Microsoft Active Directory (AD), and Microsoft Azure are all examples of identity providers.
<br>
Sometimes it is also called __asserting party__

* __Service providers (SP) authorize users:__ These systems use the authentication data from an identity provider to grant access to a service. Examples include Salesforce, Box, and other best-of-breed technology. 
<br>
Sometimes it is also called __relying party__

SAML SSO works by transferring the user’s identity from one place (the identity provider) to another (the service provider). This is done through an exchange of digitally signed XML documents.

## What SAML is used for 
SAML completely changes how users sign in to services or websites, and is intended to simplify __federated authentication and authorization processes__ for all parties: identity providers, services providers, and end users. 

Instead of requesting credentials such as a username and password for every login attempt, SAML can help verify that a user is who they say they are and confirm permission levels to either grant or deny access. In addition, SAML allows identity providers and service providers to exist separately, which helps organizations to centralize user management—and provide access to various software solutions.

SAML is most frequently used to enable single sign-on __(SSO)__, which authenticates accredited users between an identity provider and a service provider. Organizations that deploy SAML-configured applications, for example, can enable their employees to use just one set of credentials to log in to a single dashboard that gives them direct access to all of their productivity and communication tools.

## How SAML works
SAML uses Extensible Markup Language (XML) to communicate between the identity provider and service provider. This takes the form of a SAML assertion, a type of XML document that an identity provider sends to a service provider to authorize a user. 

There are three types of SAML assertions:

* __Authentication assertions__ prove a user’s identity, and provide the time that they logged in as well as the authentication protocol they used (e.g., Kerberos, multi-factor authentication). 
* __Attribution assertions__ pass SAML attributes—the pieces of data that provide information about the user—to the service provider.
* __Authorization assertions__ confirm whether the user is authorized to use a service—and what degree of authorization they have—or if the identity provider denied their request due to a password failure or lack of access rights.
To recap, SAML works by passing information about users, their logins, and their attributes between an identity provider and a service provider. When a user logs in using SSO, for example, the IdP will pass SAML attributes to the SP—ensuring the user only needs to log in once. 


## Types of Flows supported by SAML

* __Service provider-initiated SAML flow__
This occurs when a user attempts to sign in to a SAML-enabled service via its login page or mobile app. Rather than asking the user to log in, the service redirects the user to their identity provider to handle the authentication. If their identity is confirmed, they will be granted access to the site or app.
* __Identity provider-initiated SAML flow__ This flow occurs when a user logs in to the identity provider and launches a service application from their database. If they already have an account with the service provider, they will automatically gain access. If not, then some identity providers can use SAML to create a new, authenticated account for that service.

# Benefits of SAML
* Improved user experiences
* Fewer lost credentials
* Greater security
* Reduced costs
* Simplified user management

# Alternate to SAML
While SAML offers a number of benefits in terms of identity federation, there are alternative standards available that help businesses and services to securely manage and approve user identities.

* __OpenID:__ OpenID is an open source identity standard that enables users to access multiple websites and apps without sharing additional sign-in information. If you’ve ever logged in to a website using your Google, YouTube, or Facebook credentials, you’ve experienced OpenID.

* __OAuth:__ OAuth (or OpenAuth, if you want to use the full name) is a standard that was jointly developed by Google and Twitter to enable streamlined logins between websites. It’s similar to SAML in how it shares information between applications (Facebook and Google are two OAuth providers that you’ve likely used before). However, it differs by using JSON tokens to authenticate users, and as a result, is more appropriate for mobile. 

## Federated Identity 
reference https://developer.okta.com/docs/concepts/saml/#authentication 

Federated Identity started with the need to support application access that spans beyond a company or organization boundary. Imagine a relationship between a juice company (JuiceCo) selling its product to a large supermarket chain (BigMart). As an employee of JuiceCo, you need to access an application provided by BigMart to manage the relationship and monitor supplies and sales.

In this case, BigMart (who is providing this application) will need to take care of user authentication. The simple way is to require a different user name and password from users working at JuiceCo. But think about all the users that this application will need to maintain - including all of the other suppliers and their users who need to access the application.

A more elegant way to solve this problem is to allow JuiceCo and every other supplier to share or "federate" the identities with BigMart. As an employee of JuiceCo, you already have a corporate identity and credentials. What Federated Identity provides is a secure way for the supermarket chain (Service Provider) to externalize authentication by integrating with the existing identity infrastructure of its suppliers (Identity Provider).

## SAML Flow
SAML is mostly used as a web-based authentication mechanism as it relies on using the browser agent to broker the authentication flow. At a high-level, the authentication flow of SAML looks like this:
![image](diagrams\samlsimple.png)




# OCTA IDP with SAML setup 
https://www.baeldung.com/spring-security-saml 

https://github.com/rchand-git/spring-boot-saml 
https://developer.okta.com/blog/2017/03/16/spring-boot-saml

https://medium.com/digital-software-architecture/spring-boot-spring-security-with-saml-2-83d87df5b470  ---> ** 
http://www.canchito-dev.com/public/blog/2020/11/22/spring-security-with-saml2-and-okta/ --> **

https://github.com/spring-projects/spring-security-samples/tree/5.5.x/servlet/spring-boot/java/saml2-login --> **


# Further References
https://blog.joshsoftware.com/2020/04/22/single-sign-on-with-saml-and-spring-boot/
https://developer.okta.com/blog/2020/10/14/spring-security-saml-database-authentication
https://github.com/atanumallik1/SpringSecurityGeneral/blob/Autentication-Chapter1/Chapter3_SAML_Authentication.md

# Reference 
https://www.onelogin.com/learn/saml  

# Springboot SAML
https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-saml2login-sp-initiated-factory
https://github.com/spring-projects/spring-security-samples/tree/main/servlet/spring-boot/java/saml2-login 
https://codetinkering.com/spring-security-saml2-service-provider-example/
https://www.youtube.com/watch?v=kBaitgdcNWo
https://www.youtube.com/watch?v=ATdCwJXMsAQ


# SAML and SAP IDP
https://help.sap.com/viewer/65de2977205c403bbc107264b8eccf4b/Cloud/en-US/550251abaf49432bbaa65147b65a1f39.html 
https://help.sap.com/viewer/65de2977205c403bbc107264b8eccf4b/Cloud/en-US/550251abaf49432bbaa65147b65a1f39.html
https://blogs.sap.com/2021/04/15/sap-business-technology-platform-security-hands-on-video-tutorials-3/  -----> ***
https://help.sap.com/viewer/6d6d63354d1242d185ab4830fc04feb1/Cloud/en-US/d17a116432d24470930ebea41977a888.html ----> *
https://help.sap.com/viewer/6d6d63354d1242d185ab4830fc04feb1/Cloud/en-US/d483a52be22946d5a05951b0fa16221f.html ---> *
https://blogs.sap.com/2021/06/29/configure-single-sign-on-with-okta-sap-btp-launchpad-service-on-cloud-foundry/ --->*
https://help.sap.com/viewer/cca91383641e40ffbe03bdc78f00f681/Cloud/en-US/a4ee70f0274248f8bbc7594179ef948d.html


# Google Identity
https://www.youtube.com/watch?v=ny92vcpOQFs

