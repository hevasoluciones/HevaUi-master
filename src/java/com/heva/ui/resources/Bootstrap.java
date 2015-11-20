/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.resources;

import com.heva.ui.base.Style;
import com.heva.ui.constants.Constants;

/**
 *
 * @author Rafa
 */
public interface Bootstrap {


	public static final String prev = "prev";

	public static final String next = "next";

	public static final String block_message = "block-message";

	public static final String large = "large";

	public static final String small = "small";

	public static final String container = "container";

	public static final String sidebar = "sidebar";

	public static final String nav = "nav";

	public static final String nav_list = "nav-list";

	public static final String nav_header = "nav-header";

	public static final String menu = "menu";

	public static final String menu_dropdown = "menu-dropdown";

	public static final String clearfix = "clearfix";

	public static final String input = "input";

	public static final String uneditable_input = "uneditable-input";

	public static final String search_query = "search-query";

	public static final String inverse = "inverse";

	public static final String page_header = "page-header";

	public static final String hero_unit = "hero-unit";

	public static final String progress_striped = "progress-striped";

	public static final String progress_animated = "progress-striped "
			+ Constants.ACTIVE;

	public static final String pager = "pager";

	public static final String linenums = "linenums";

	public static final String prettyprint = "prettyprint";

	public static final String nav_tabs = "nav-tabs";

	public static final String nav_pills = "nav-pills";

	public static final String nav_stacked = "nav-stacked";

	public static final String tabbable = "tabbable";

	public static final String tab_pane = "tab-pane";

	public static final String tab_content = "tab-content";

	public static final String footer = "footer";

	public enum Tabs implements Style {

		ABOVE(""),
		BELOW("tabs-below"),
		LEFT("tabs-left"),
		RIGHT("tabs-right");
		
		private static final String tabbable = "tabbable ";

		private String className;

		private Tabs(String className) {
			this.className = tabbable + className;
		}

		public String get() {
			return className;
		}
	}

	public enum Pagination implements Style {

		LEFT(""), CENTERED("pagination-centered"), RIGHT("pagination-right");

		private static final String pagination = "pagination ";

		private String className;

		private Pagination(String className) {
			this.className = pagination + className;
		}

		public String get() {
			return className;
		}
	}

}