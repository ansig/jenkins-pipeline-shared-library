package se.ansig.sample.jenkins.pipeline

class Steps {

  /**
    * This is my custom step.
    */
  static def myCustomStep(script, arg) {
    script.echo "Performing my custom step with arg: ${arg}"
    script.sh "sleep 10 && echo 'Done'"
  }
}
