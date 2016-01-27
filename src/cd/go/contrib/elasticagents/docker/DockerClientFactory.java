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

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificates;
import com.spotify.docker.client.DockerClient;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class DockerClientFactory {

    private static DefaultDockerClient client;
    private static PluginSettings pluginSettings;

    public static synchronized DockerClient docker(PluginSettings pluginSettings) throws Exception {
        if (pluginSettings.equals(DockerClientFactory.pluginSettings) && DockerClientFactory.client != null) {
            return DockerClientFactory.client;
        }

        DockerClientFactory.pluginSettings = pluginSettings;
        DockerClientFactory.client = createClient(pluginSettings);
        return DockerClientFactory.client;
    }

    private static DefaultDockerClient createClient(PluginSettings pluginSettings) throws Exception {
        Path certificateDir = Files.createTempDirectory(UUID.randomUUID().toString());
        File tempDirectory = certificateDir.toFile();

        try {
            FileUtils.writeStringToFile(new File(tempDirectory, DockerCertificates.DEFAULT_CA_CERT_NAME), pluginSettings.dockerCACert);
            FileUtils.writeStringToFile(new File(tempDirectory, DockerCertificates.DEFAULT_CLIENT_CERT_NAME), pluginSettings.dockerClientCert);
            FileUtils.writeStringToFile(new File(tempDirectory, DockerCertificates.DEFAULT_CLIENT_KEY_NAME), pluginSettings.dockerClientKey);

            DefaultDockerClient docker = DefaultDockerClient.builder()
                    .uri(URI.create(pluginSettings.dockerURI))
                    .dockerCertificates(new DockerCertificates(certificateDir))
                    .build();
            String ping = docker.ping();
            if (!"OK".equals(ping)) {
                throw new RuntimeException("Could not ping the docker server, the server said '" + ping + "' instead of 'OK'.");
            }
            return docker;
        } finally {
            FileUtils.deleteDirectory(tempDirectory);
        }
    }
}
