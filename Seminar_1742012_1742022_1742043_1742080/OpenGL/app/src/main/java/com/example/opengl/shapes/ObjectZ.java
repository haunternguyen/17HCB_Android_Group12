package com.example.opengl.shapes;

import javax.microedition.khronos.opengles.GL10;

public class ObjectZ extends AbstractDraw implements IShape {

	String color = "#00D200";
	
	boolean objectMatrix[][][];

	public ObjectZ() {
		objectMatrix = createFalsMatrix(3);
		objectMatrix[1][0][0] = true;
		objectMatrix[2][0][0] = true;
		objectMatrix[0][0][1] = true;
		objectMatrix[1][0][1] = true;
	}

	@Override
	public void draw(GL10 gl) {
		drawObject(gl, objectMatrix, color);
		/*gl.glPushMatrix();
		Cube c1 = new Cube(color);
		gl.glTranslatef(0, 0, 1);
		c1.draw(gl);

		Cube c2 = new Cube(color);
		gl.glTranslatef(1, 0, 0);
		c2.draw(gl);

		Cube c3 = new Cube(color);
		gl.glTranslatef(0, 0, -1);
		c3.draw(gl);

		Cube c4 = new Cube(color);
		gl.glTranslatef(1, 0, 0);
		c4.draw(gl);
		gl.glPopMatrix();*/
	}

	@Override
	public boolean[][][] getObjectMatrix() { 
		return objectMatrix;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public int getXsize() {
		return getXsize(objectMatrix);
	}

	@Override
	public int getYsize() {
		return getYsize(objectMatrix);
	}
	
	@Override
	public int getZsize() {
		return getZsize(objectMatrix);
	}
	
	@Override
	public void rotate(int axis) {
		switch(axis){
			case 1:
			case 'x':
				objectMatrix = rotateX(objectMatrix); break;
			case 2:
			case 'y':
				objectMatrix = rotateY(objectMatrix); break;
			case 3:
			case 'z':
				objectMatrix = rotateZ(objectMatrix); break;				
		}
	}

}
