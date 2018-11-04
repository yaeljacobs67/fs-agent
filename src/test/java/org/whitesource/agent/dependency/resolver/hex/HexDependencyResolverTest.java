package org.whitesource.agent.dependency.resolver.hex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.whitesource.agent.api.model.DependencyInfo;
import org.whitesource.agent.dependency.resolver.ruby.RubyDependencyResolver;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.*;

public class HexDependencyResolverTest {

    HexDependencyResolver hexDependencyResolver;

    @Before
    public void setUp() throws Exception {
        hexDependencyResolver = new HexDependencyResolver(true, true);
    }
    @Test
    public void parseMixLoc() {
        HashMap<String, DependencyInfo> stringDependencyInfoHashMap = hexDependencyResolver.parseMixLoc(new File("C:\\Users\\ErezHuberman\\Documents\\===HEX===\\imager-master\\mix.lock"));
        Assert.assertTrue(stringDependencyInfoHashMap != null);
    }
}