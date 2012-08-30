package hudson.plugins.scm_sync_configuration;

import org.apache.maven.scm.manager.BasicScmManager;
import org.apache.maven.scm.manager.ScmManager;
import org.apache.maven.scm.provider.git.gitexe.GitExeScmProvider;
import org.apache.maven.scm.provider.svn.svnjava.SvnJavaScmProvider;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.PlexusContainerException;
import org.codehaus.plexus.component.repository.exception.ComponentLookupException;
import org.codehaus.plexus.embed.Embedder;

public class SCMManagerFactory {

    private static final SCMManagerFactory INSTANCE = new SCMManagerFactory();
    private Embedder plexus = null;
    
    private ScmManager scmManager;

    private SCMManagerFactory() {
    }

    public void start() throws PlexusContainerException {
        plexus = new Embedder();
        plexus.start();
    }

    public ScmManager createScmManager() throws ComponentLookupException {
        //return (ScmManager) this.plexus.lookup(ScmManager.ROLE);
       // TODO: find why Plexus is not looking up the providers
        scmManager = new BasicScmManager();
        scmManager.setScmProvider( "git", new GitExeScmProvider() );
        scmManager.setScmProvider( "svn", new SvnJavaScmProvider() );
        return scmManager;
    }

    public void stop() throws Exception {
        this.plexus.stop();
        this.plexus = null;
    }

    public static SCMManagerFactory getInstance() {
        return INSTANCE;
    }
}
