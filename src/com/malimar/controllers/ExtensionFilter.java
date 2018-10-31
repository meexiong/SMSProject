/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Malimar
 */
public class ExtensionFilter implements FilenameFilter {
 
	private String extension;
	
	public ExtensionFilter(String extension) {
		this.extension = extension;
	}
	
	/**
	 * Accepting only files ending with the extension.
	 */
	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}
 
}
