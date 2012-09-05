/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-search-analysis-provider RebirthAnalyzerProvider.java 2012-7-6 14:12:27 l.xue.nong$$
 */
package cn.com.rebirth.search.analysis.provider.index;

import cn.com.rebirth.analyzer.support.RebirthAnalyzer;
import cn.com.rebirth.analyzer.support.RebirthAnalyzersFactory;
import cn.com.rebirth.commons.settings.Settings;
import cn.com.rebirth.core.inject.Inject;
import cn.com.rebirth.core.inject.assistedinject.Assisted;
import cn.com.rebirth.search.core.env.Environment;
import cn.com.rebirth.search.core.index.Index;
import cn.com.rebirth.search.core.index.analysis.AbstractIndexAnalyzerProvider;
import cn.com.rebirth.search.core.index.settings.IndexSettings;
import cn.com.rebirth.search.index.analysis.AnalyzerScope;

/**
 * The Class RebirthAnalyzerProvider.
 *
 * @author l.xue.nong
 */
public class RebirthAnalyzerProvider extends AbstractIndexAnalyzerProvider<RebirthAnalyzer> {

	/** The sum mall analyzer. */
	private final RebirthAnalyzer sumMallAnalyzer;

	/**
	 * Instantiates a new rebirth analyzer provider.
	 *
	 * @param index the index
	 * @param indexSettings the index settings
	 * @param env the env
	 * @param name the name
	 * @param settings the settings
	 */
	@Inject
	public RebirthAnalyzerProvider(Index index, @IndexSettings Settings indexSettings, Environment env,
			@Assisted String name, @Assisted Settings settings) {
		super(index, indexSettings, name, settings);
		this.sumMallAnalyzer = new RebirthAnalyzer(RebirthAnalyzersFactory.getAnalyzers(indexSettings.get(
				"rebirth.analyzer.type", "rebirthAnalyzer-Impl-Paoding(2.0.4.beta)")));
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.search.core.index.analysis.AnalyzerProvider#get()
	 */
	@Override
	public RebirthAnalyzer get() {
		return this.sumMallAnalyzer;
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.search.core.index.analysis.AbstractIndexAnalyzerProvider#name()
	 */
	@Override
	public String name() {
		return this.sumMallAnalyzer.getMallAnalyzers().getAnalyzerImplName();
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.search.core.index.analysis.AbstractIndexAnalyzerProvider#scope()
	 */
	@Override
	public AnalyzerScope scope() {
		return AnalyzerScope.INDEX;
	}

}
