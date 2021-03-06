package com.wini.online.render;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.b3log.latke.servlet.HTTPRequestContext;
import org.b3log.latke.servlet.renderer.freemarker.AbstractFreeMarkerRenderer;
import org.b3log.solo.SoloServletListener;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FrontRender extends AbstractFreeMarkerRenderer {
	
	private static final Logger LOGGER = Logger.getLogger(FrontRender.class.getName());
	public static final Configuration TEMPLATE_CFG;
	
	static{
		TEMPLATE_CFG = new Configuration();
		TEMPLATE_CFG.setDefaultEncoding("UTF-8");
        try {
            final String webRootPath = SoloServletListener.getWebRoot();
            TEMPLATE_CFG.setDirectoryForTemplateLoading(new File(webRootPath));
        } catch (final IOException e) {
            LOGGER.log(Level.SEVERE,"初始化路径模板路径失败",e);
        }
	}
	

	@Override
	protected Template getTemplate(String templateDirName, String templateName) throws IOException {
		return TEMPLATE_CFG.getTemplate(templateName);
	}

	@Override
	protected void beforeRender(HTTPRequestContext context) throws Exception {

	}

	@Override
	protected void afterRender(HTTPRequestContext context) throws Exception {

	}

}
