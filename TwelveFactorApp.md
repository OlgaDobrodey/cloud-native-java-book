https://bool.dev/blog/detail/twelve-factor-app https://12factor.net/ru/ https://en.wikipedia.org/wiki/Twelve-Factor_App_methodology https://habr.com/ru/post/261171/

###12 factors developers should think about when building native cloud apps.

####Code base Use one codebase, even when building cross-platform apps. Address the needs of specific devices with Version control.

####Dependencies Explicitly declare and isolate all dependencies.

####Configuration Don’t store config as constants in code. Instead, design the app to read its config from the environment.

####Backing Services Treat back-end services as attached resources to be accessed with a URL or other locator stored in config.

####Build, Release, Run Strictly separate build and run stages.

####Processes Execute the app as one or more stateless processes. Data that must be persistent should be stored in a stateful backing service.

####Port binding Use port binding to export services.

####Concurrency Scale out apps horizontally, not vertically.

####Disposability Use fast startups and graceful shutdowns to maximize robustness.

####Parity Facilitate continuous deployment by ensuring that development, staging, and production environments are as similar as possible.

####Logs Treat logs as event streams. Logs should not be concerned with routing or storing the app’s output.

####Admin processes Run admin tasks as one-off processes from a machine in the production environment that’s running the latest production code.

###The 12-factor basics When a developer uses the twelve-factor app DevOps methodology, applications will have certain characteristics in common that address a variety of scenarios as an app scales. For example, the methodology recommends that apps use declarative formats for setup automation to assist new developers that enter the project at a later time.

Apps should also be written to have maximum portability between execution environments. and scale easily without significant reworking. Twelve-factor apps can be written in any programming language and in combination with any back-end service, such as a database.

The goal of the twelve-factor framework is to help developers build apps that use an architecture that ensures speed, reliability, agility, portability and ultimately results in a robust and reliable application.