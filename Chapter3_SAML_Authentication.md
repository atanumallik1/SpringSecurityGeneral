SAML SSO works by transferring the user’s identity from one place (the identity provider) to another (the service provider). This is done through an exchange of digitally signed XML documents.

Consider the following scenario: A user is logged into a system that acts as an identity provider. The user wants to log in to a remote application, such as a support or accounting application (the service provider). The following happens:

The user accesses the remote application using a link on an intranet, a bookmark, or similar and the application loads.

The application identifies the user’s origin (by application subdomain, user IP address, or similar) and redirects the user back to the identity provider, asking for authentication. This is the authentication request.

The user either has an existing active browser session with the identity provider or establishes one by logging into the identity provider.

The identity provider builds the authentication response in the form of an XML-document containing the user’s username or email address, signs it using an X.509 certificate, and posts this information to the service provider.

The service provider, which already knows the identity provider and has a certificate fingerprint, retrieves the authentication response and validates it using the certificate fingerprint.

The identity of the user is established and the user is provided with app access.


https://blog.joshsoftware.com/2020/04/22/single-sign-on-with-saml-and-spring-boot/
https://developer.okta.com/blog/2020/10/14/spring-security-saml-database-authentication

# Reference 
https://www.onelogin.com/learn/saml 
