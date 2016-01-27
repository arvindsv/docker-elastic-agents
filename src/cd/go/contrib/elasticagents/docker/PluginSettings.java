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

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PluginSettings {
    public static final Gson GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).excludeFieldsWithoutExposeAnnotation().create();

    @Expose
    @SerializedName("resources")
    public String resources;

    @Expose
    @SerializedName("environments")
    public String environments;

    @Expose
    @SerializedName("go_server_url")
    public String goServerUrl;

    @Expose
    @SerializedName("docker_uri")
    public String dockerURI;

    @Expose
    @SerializedName("auto_register_timeout")
    public String autoRegisterTimeout;

    @Expose
    @SerializedName("docker_ca_cert")
    public String dockerCACert;

    @Expose
    @SerializedName("docker_client_cert")
    public String dockerClientCert;

    @Expose
    @SerializedName("docker_client_key")
    public String dockerClientKey;

    public static PluginSettings fromJSON(String json) {
        return GSON.fromJson(json, PluginSettings.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PluginSettings that = (PluginSettings) o;

        if (resources != null ? !resources.equals(that.resources) : that.resources != null) return false;
        if (environments != null ? !environments.equals(that.environments) : that.environments != null) return false;
        if (goServerUrl != null ? !goServerUrl.equals(that.goServerUrl) : that.goServerUrl != null) return false;
        if (dockerURI != null ? !dockerURI.equals(that.dockerURI) : that.dockerURI != null) return false;
        if (autoRegisterTimeout != null ? !autoRegisterTimeout.equals(that.autoRegisterTimeout) : that.autoRegisterTimeout != null)
            return false;
        if (dockerCACert != null ? !dockerCACert.equals(that.dockerCACert) : that.dockerCACert != null) return false;
        if (dockerClientCert != null ? !dockerClientCert.equals(that.dockerClientCert) : that.dockerClientCert != null)
            return false;
        return dockerClientKey != null ? dockerClientKey.equals(that.dockerClientKey) : that.dockerClientKey == null;

    }

    @Override
    public int hashCode() {
        int result = resources != null ? resources.hashCode() : 0;
        result = 31 * result + (environments != null ? environments.hashCode() : 0);
        result = 31 * result + (goServerUrl != null ? goServerUrl.hashCode() : 0);
        result = 31 * result + (dockerURI != null ? dockerURI.hashCode() : 0);
        result = 31 * result + (autoRegisterTimeout != null ? autoRegisterTimeout.hashCode() : 0);
        result = 31 * result + (dockerCACert != null ? dockerCACert.hashCode() : 0);
        result = 31 * result + (dockerClientCert != null ? dockerClientCert.hashCode() : 0);
        result = 31 * result + (dockerClientKey != null ? dockerClientKey.hashCode() : 0);
        return result;
    }
}
