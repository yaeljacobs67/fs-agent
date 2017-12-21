package org.whitesource.fs;
import org.junit.Assert;
import org.junit.Test;
import org.whitesource.agent.api.model.AgentProjectInfo;
import org.whitesource.agent.dependency.resolver.npm.TestHelper;
import org.whitesource.agent.utils.Pair;

import java.io.*;
import java.util.Collection;
import java.util.Properties;

import static org.whitesource.agent.ConfigPropertyKeys.PROJECT_PER_SUBFOLDER;

public class MainTest {

    @Test
    public void shouldWorkWithProjectPerFolder() throws IOException {
        File config = TestHelper.getFileFromResources(CommandLineArgs.CONFIG_FILE_NAME);
        String[] commandLineArgs = new String[]{"-c", config.getAbsolutePath(), "-d", new File(TestHelper.FOLDER_WITH_MIX_FOLDERS).getAbsolutePath(), "-"+ PROJECT_PER_SUBFOLDER, "true"};

        Properties properties = Main.getProperties(commandLineArgs);
        // read configuration properties
        String project = null;

        Pair<Collection<AgentProjectInfo>,StatusCode> projects = Main.getAllProjects(properties, project);

        Assert.assertTrue(projects.getKey().size() > 1);
    }
}
