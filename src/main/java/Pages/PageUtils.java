/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

import javax.swing.JFrame;

public class PageUtils {
	
	private JFrame originalFrame, targetedFrame;

	public PageUtils() {
	}

	public JFrame getOriginalFrame() {
		return originalFrame;
	}

	public void setOriginalFrame(JFrame originalFrame) {
		this.originalFrame = originalFrame;
	}

	public JFrame getTargetedFrame() {
		return targetedFrame;
	}

	public void setTargetedFrame(JFrame targetedFrame) {
		this.targetedFrame = targetedFrame;
	} 
	
	public void navigatePage() {
		targetedFrame.setVisible(true);
		originalFrame.setVisible(false);
	} 
	
}

