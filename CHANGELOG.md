## 0.6.0 - 2016-11-19

### Added

- Added support for a few additional calls required by the GoCD server.
  * `go.cd.elastic-agent.get-profile-metadata`
  * `go.cd.elastic-agent.get-profile-view`
  * `go.cd.elastic-agent.validate-profile`
  * `go.cd.elastic-agent.get-icon`

## 0.5.0 - 2016-10-06

### Fixed

- Fix some synchronization issues that allowed more number of containers than the settings permitted

## 0.4.0 - 2016-09-29

### Changed

- The `AUTO_REGISTER_CONTENTS` contents environment variable has now been split up into 4 separate variables ([details here](https://docs.go.cd/current/advanced_usage/agent_auto_register.html)) —
  * `GO_EA_AUTO_REGISTER_KEY` - the auto-register key
  * `GO_EA_AUTO_REGISTER_ENVIRONMENT` - the auto-register environment
  * `GO_EA_AUTO_REGISTER_ELASTIC_AGENT_ID` - the elastic agent id
  * `GO_EA_AUTO_REGISTER_ELASTIC_PLUGIN_ID` — the elastic plugin id

### Added

- The command to execute in the docker container can now be specified using the `Command` property —

    ```xml
    <profile pluginId="cd.go.contrib.elastic-agent.docker" id="foo">
      <property>
        <key>Command</key>
        <value>
          JAVA_HOME=/opt/java
          MAKE_OPTS=-j8
        </value>
      </property>
    </profile>
    ```


## 0.3.0 - 2016-09-12

### Bug fixes

- Do not attempt to load docker certificates if they are not specified in the configuration
- When terminating instances that did not register after a timeout, gracefully handle a `ContainerNotFoundException`, in case the container was cleaned up by other means

## 0.2.0 - 2016-08-26

### Added

- Environment variables can be specified using the `Environment` property —

    ```xml
    <profile pluginId="cd.go.contrib.elastic-agent.docker" id="foo">
      <property>
        <key>Environment</key>
        <value>
          JAVA_HOME=/opt/java
          MAKE_OPTS=-j8
        </value>
      </property>
    </profile>
    ```

- If you'd like to specify environment variables globally for all containers, the plugin settings will let you do just that.
- Added support for a plugin setting to limit the maximum number of containers that should be started up.

## 0.1.0 - 2016-08-18

Initial release of plugin
