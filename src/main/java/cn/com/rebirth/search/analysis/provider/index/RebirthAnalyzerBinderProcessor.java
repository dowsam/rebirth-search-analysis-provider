/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-search-analysis-provider RebirthAnalyzerBinderProcessor.java 2012-7-6 14:12:26 l.xue.nong$$
 */
package cn.com.rebirth.search.analysis.provider.index;

import cn.com.rebirth.analyzer.RebirthAnalyzers;
import cn.com.rebirth.analyzer.support.RebirthAnalyzersFactory;
import cn.com.rebirth.commons.settings.Settings;
import cn.com.rebirth.search.core.index.analysis.AnalysisModule;

/**
 * The Class RebirthAnalyzerBinderProcessor.
 *
 * @author l.xue.nong
 */
public class RebirthAnalyzerBinderProcessor extends AnalysisModule.AnalysisBinderProcessor {

	/** The settings. */
	private final Settings settings;

	/**
	 * Instantiates a new rebirth analyzer binder processor.
	 *
	 * @param settings the settings
	 */
	public RebirthAnalyzerBinderProcessor(Settings settings) {
		super();
		this.settings = settings;
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.search.core.index.analysis.AnalysisModule.AnalysisBinderProcessor#processAnalyzers(cn.com.rebirth.search.core.index.analysis.AnalysisModule.AnalysisBinderProcessor.AnalyzersBindings)
	 */
	@Override
	public void processAnalyzers(AnalyzersBindings analyzersBindings) {
		RebirthAnalyzers analyzers = RebirthAnalyzersFactory.getAnalyzers(settings.get("rebirth.analyzer.type",
				"rebirthAnalyzer-Impl-Paoding(2.0.4.beta)"));
		analyzersBindings.processAnalyzer(analyzers.getAnalyzerImplName(), RebirthAnalyzerProvider.class);
		super.processAnalyzers(analyzersBindings);
	}

}
