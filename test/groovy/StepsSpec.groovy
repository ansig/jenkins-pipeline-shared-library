import spock.lang.Specification
import se.ansig.sample.jenkins.pipeline.Steps

class StepsSpec extends Specification {

    def "check that myCustomStep does stuff"(){
        setup:
        Pipeline script = Mock()

        when:
        Steps.myCustomStep(script, 'foo')

        then:
        1 * script.echo("Performing my custom step with arg: foo")
    }

    // Return an instance of the utility step class that forwards any missing method
    // calls to the provided delegate.
    private def getStubbedSteps(def delegate) {
        def step = this.class.classLoader
                .loadClass("se.ansig.sample.jenkins.pipeline.Steps").newInstance()
        step.metaClass.methodMissing { String method, def args ->
            delegate."${method}"(*args)
        }
        return step
    }
}
