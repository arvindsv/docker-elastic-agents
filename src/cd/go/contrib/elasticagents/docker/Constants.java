/*
 * Copyright 2016 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cd.go.contrib.elasticagents.docker;

public interface Constants {
    String PLUGIN_ID = "cd.go.contrib.elastic-agents.docker";

    String EXTENSION_NAME = "elastic-agent";

    String REQUEST_PREFIX = "go.cd.elastic-agent";

    String REQUEST_CREATE_AGENT = REQUEST_PREFIX + ".create-agent";
    String REQUEST_CAN_PLUGIN_HANDLE = REQUEST_PREFIX + ".can-plugin-handle";
    String REQUEST_SERVER_PING = REQUEST_PREFIX + ".server-ping";
    String REQUEST_SHOULD_ASSIGN_WORK = REQUEST_PREFIX + ".should-assign-work";
    String REQUEST_NOTIFY_AGENT_BUSY = REQUEST_PREFIX + ".notify-agent-busy";

    // requests that the plugin makes to the server
    String REQUEST_SERVER_PREFIX = "go.processor";
    String REQUEST_SERVER_DISABLE_AGENT = REQUEST_SERVER_PREFIX + ".elasticagent.disable-agent";
    String REQUEST_SERVER_DELETE_AGENT = REQUEST_SERVER_PREFIX + ".elasticagent.delete-agent";
    String REQUEST_SERVER_GET_PLUGIN_SETTINGS = REQUEST_SERVER_PREFIX + ".plugin-settings.get";

    // settings related requests that the server makes to the plugin
    String GO_PLUGIN_SETTINGS_PREFIX = "go.plugin-settings";
    String PLUGIN_SETTINGS_GET_CONFIGURATION = GO_PLUGIN_SETTINGS_PREFIX + ".get-configuration";
    String PLUGIN_SETTINGS_GET_VIEW = GO_PLUGIN_SETTINGS_PREFIX + ".get-view";
    String PLUGIN_SETTINGS_VALIDATE_CONFIGURATION = GO_PLUGIN_SETTINGS_PREFIX + ".validate-configuration";

    // internal use only
    String CREATED_BY_LABEL_KEY = "Elastic-Agent-Created-By";

}
