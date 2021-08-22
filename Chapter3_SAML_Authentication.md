SAML SSO works by transferring the user’s identity from one place (the identity provider) to another (the service provider). This is done through an exchange of digitally signed XML documents.

Consider the following scenario: A user is logged into a system that acts as an identity provider. The user wants to log in to a remote application, such as a support or accounting application (the service provider). The following happens:

The user accesses the remote application using a link on an intranet, a bookmark, or similar and the application loads.

The application identifies the user’s origin (by application subdomain, user IP address, or similar) and redirects the user back to the identity provider, asking for authentication. This is the authentication request.

The user either has an existing active browser session with the identity provider or establishes one by logging into the identity provider.

The identity provider builds the authentication response in the form of an XML-document containing the user’s username or email address, signs it using an X.509 certificate, and posts this information to the service provider.

The service provider, which already knows the identity provider and has a certificate fingerprint, retrieves the authentication response and validates it using the certificate fingerprint.

The identity of the user is established and the user is provided with app access.


# The Big Picture
Security Assertion Markup Language (SAML) is an open standard that allows an IdP to securely send the user's authentication and authorization details to the Service Provider (SP). It uses XML-based messages for the communication between the IdP and the SP.

In other words, when a user attempts to access a service, he's required to log in with the IdP. Once logged in, the IdP sends the SAML attributes with authorization and authentication details in the XML format to the SP.

Apart from providing a secured authentication-transmission mechanism, SAML also promotes Single Sign-On (SSO), allowing users to log in once and reuse the same credentials to log into other service providers.




# OCTA IDP with SAML setup 
https://www.baeldung.com/spring-security-saml 

https://github.com/rchand-git/spring-boot-saml 
https://developer.okta.com/blog/2017/03/16/spring-boot-saml

https://medium.com/digital-software-architecture/spring-boot-spring-security-with-saml-2-83d87df5b470  ---> ** 


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

