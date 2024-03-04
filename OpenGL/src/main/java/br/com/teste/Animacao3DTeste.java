package br.com.teste;

import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLUtil;

public class Animacao3DTeste {
	public static void main(String[] args) {
		// Setup GLFW
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Create the window
        long window = GLFW.glfwCreateWindow(800, 600, "OpenGL Example", NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Make the OpenGL context current
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GLUtil.setupDebugMessageCallback();

        // Setup OpenGL
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glEnable(GL11.GL_DEPTH_TEST);

        // Main loop
        while (!GLFW.glfwWindowShouldClose(window)) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            // Set up perspective projection
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GL11.glOrtho(-2, 2, -2, 2, -2, 2);

            // Set up modelview matrix
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0f, 0.0f, -2.0f);
            GL11.glRotatef((float) GLFW.glfwGetTime() * 50.0f, 1.0f, 1.0f, 1.0f);

            // Render a cube with depth
            GL11.glBegin(GL11.GL_QUADS);
            // Front face
            GL11.glColor3f(1.0f, 0.0f, 0.0f);
            GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
            GL11.glVertex3f(1.0f, -1.0f, 1.0f);
            GL11.glVertex3f(1.0f, 1.0f, 1.0f);
            GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
            // Back face
            GL11.glColor3f(0.0f, 1.0f, 0.0f);
            GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
            GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
            GL11.glVertex3f(1.0f, 1.0f, -1.0f);
            GL11.glVertex3f(1.0f, -1.0f, -1.0f);
            // Top face
            GL11.glColor3f(0.0f, 0.0f, 1.0f);
            GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
            GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
            GL11.glVertex3f(1.0f, 1.0f, 1.0f);
            GL11.glVertex3f(1.0f, 1.0f, -1.0f);
            // Bottom face
            GL11.glColor3f(1.0f, 1.0f, 0.0f);
            GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
            GL11.glVertex3f(1.0f, -1.0f, -1.0f);
            GL11.glVertex3f(1.0f, -1.0f, 1.0f);
            GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
            // Right face
            GL11.glColor3f(1.0f, 0.0f, 1.0f);
            GL11.glVertex3f(1.0f, -1.0f, -1.0f);
            GL11.glVertex3f(1.0f, 1.0f, -1.0f);
            GL11.glVertex3f(1.0f, 1.0f, 1.0f);
            GL11.glVertex3f(1.0f, -1.0f, 1.0f);
            // Left face
            GL11.glColor3f(0.0f, 1.0f, 1.0f);
            GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
            GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
            GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
            GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
            GL11.glEnd();

            // Swap buffers and poll events
            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }

        // Clean up
        GLFW.glfwTerminate();
	}
}
