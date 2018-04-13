/**
 * Logging methods that can be called from pipelines.
 */

package se.ansig.sample.jenkins.pipeline.utility

def fatal(message) {
  echo "FATAL: ${message}"
}

def error(message) {
  echo "ERROR: ${message}"
}

def debug(message) {
  echo "DEBUG: ${message}"
}

def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
}
