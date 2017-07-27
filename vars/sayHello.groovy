package se.ansig.sample.jenkins.pipeline.utility

/**
 * Says hello to the specified name in the console log.
 *
 * @param name whom to greet. Default: world
 */
def call(String name = "world") {
    echo "Hello ${name}!"
}
