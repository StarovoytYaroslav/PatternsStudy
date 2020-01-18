package com.yaroslav.structural.adapter.composition;

public class VectorAdapterFromRaster implements VectorGraphicsInterface {
	
	RasterGraphics raster = new RasterGraphics();
	
	@Override
	public void drawLine() {
		raster.drawRasterLine();
	}

	@Override
	public void drawSquare() {
		raster.drawRasterSquare();
	}

}
