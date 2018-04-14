/**
 * Interface that defines all expected calls to Pipeline script steps.
 */
interface Pipeline {
    void echo(Object... args)
    void sh(Object... args)
}
