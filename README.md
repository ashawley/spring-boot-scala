Spring Boot 1.x in Scala
========================

Run [Spring Boot] 1.5 from [Scala] and [sbt].

Starting
--------

Open sbt from a console:

    $ sbt

From the sbt prompt, start the application with [sbt-revolver]:

    > re-start

To stop to the application:

    > re-stop


Testing
-------

Run the test suite from the sbt prompt:

    > test

Triggered execution
-------------------

It is possible for sbt to poll your sources and automatically run the
build again for you.

Here is how to run the app, and have it be restarted on every source
file change:

    > ~re-start

After exiting, be sure to still stop the forked application process with:

    > re-stop

To run the test suite whenever the sources or a test are changed:

    > ~test

[Spring Boot]: https://spring.io/projects/spring-boot
[Scala]: https://scala-lang.org
[sbt]: https://scala-sbt.org
[sbt-revolver]: https://github.com/spray/sbt-revolver
