package hudson.plugins.scm_sync_configuration.extensions;

import hudson.Extension;
import hudson.model.PageDecorator;
import hudson.plugins.scm_sync_configuration.ScmSyncConfigurationPlugin;

@Extension
public class ScmSyncConfigurationPageDecorator extends PageDecorator{

	public ScmSyncConfigurationPageDecorator(){
		super(ScmSyncConfigurationPageDecorator.class);
	}
	
//        @Override
//	public ScmSyncConfigurationPlugin getPlugin(){
//		return new ScmSyncConfigurationPlugin.getInstance();
//	}
	
}