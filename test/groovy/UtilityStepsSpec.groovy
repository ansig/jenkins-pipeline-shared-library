import spock.lang.Specification

class UtilityStepsSpec extends Specification {

    def "sayHello says hello to given name"(){
        setup:
        Pipeline script = Mock()
        def stepInstance = getStubbedUtilityStep("sayHello", script)

        when:
        stepInstance.call(name)

        then:
        1 * script.echo("Hello ${name}!")

        where:
        name << ["Anders"]
    }

    // Return an instance of the utility step class that forwards any missing method
    // calls to the provided delegate.
    private def getStubbedUtilityStep(String stepName, def delegate) {
        def step = this.class.classLoader
                .loadClass("se.ansig.sample.jenkins.pipeline.utility.${stepName}").newInstance()
        step.metaClass.methodMissing { String method, def args ->
            delegate."${method}"(*args)
        }
        return step
    }
}
