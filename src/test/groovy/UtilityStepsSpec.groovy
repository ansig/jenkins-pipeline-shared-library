import spock.lang.Specification

class UtilityStepsSpec extends Specification {

    def "sayHello says hello to given name"(){
        setup:
        JobDSL jobDSL = Mock()
        def stepInstance = getStubbedUtilityStep("sayHello", jobDSL)

        when:
        stepInstance.call(name)

        then:
        1 * jobDSL.echo("Hello ${name}!")

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

/**
 * Interface that defines all expected calls to JobDSL steps.
 */
interface JobDSL {
    void echo(Object... args)
}
