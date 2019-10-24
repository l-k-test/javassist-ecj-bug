# javassist-ecj-bug
A small project that demonstrates a bug in javassist with classes compiled by the eclipse compiler. This was verified with JDK 1.8.0_192-b12.

The project contains 2 tests: JUnitJavassistTest and PowerMockJavassistTest.
The only difference between them is that PowerMockJavassistTest has <code>PowerMockRunner.class</code> annotation,
so some javassist bytecode manipulation is performed.

Running <code>mvn clean test</code> executes JUnitJavassistTest.
PowerMockJavassistTest is activated with pmock maven profile: <code>mvn clean test -Ppmock</code>.
Both commands complete successfully.

The project can also use the eclipse compiler instead of the default JDK compiler.
The eclipse compiler is activated with ecj maven profile: <code>mvn clean test -Pecj</code>.
This command completes successfully.

But combining the eclipse compiler with PowerMock (<code>mvn clean test -Ppmock,ecj</code>) fails with:
<pre>
java.lang.VerifyError: Stack map does not match the one at exception handler 103
</pre>
