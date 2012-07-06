/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-search-analysis-provider RebirthAnalyzerPlugin.java 2012-7-6 14:12:26 l.xue.nong$$
 */
package cn.com.rebirth.search.analysis.provider.plugin;

import cn.com.rebirth.commons.settings.Settings;
import cn.com.rebirth.search.analysis.provider.index.RebirthAnalyzerBinderProcessor;
import cn.com.rebirth.search.core.index.analysis.AnalysisModule;
import cn.com.rebirth.search.core.plugins.AbstractPlugin;

/**
 * The Class RebirthAnalyzerPlugin.
 *
 * @author l.xue.nong
 */
public class RebirthAnalyzerPlugin extends AbstractPlugin {

	/** The settings. */
	private final Settings settings;

	/**
	 * Instantiates a new rebirth analyzer plugin.
	 *
	 * @param settings the settings
	 */
	public RebirthAnalyzerPlugin(Settings settings) {
		this.settings = settings;
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.search.core.plugins.Plugin#name()
	 */
	@Override
	public String name() {
		return "analysis-rebirth-provider";
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.search.core.plugins.Plugin#description()
	 */
	@Override
	public String description() {
		return "rebirth-analyzer-provider";
	}

	/**
	 * On module.
	 *
	 * @param module the module
	 */
	public void onModule(AnalysisModule module) {
		module.addProcessor(new RebirthAnalyzerBinderProcessor(this.settings));
	}
}
