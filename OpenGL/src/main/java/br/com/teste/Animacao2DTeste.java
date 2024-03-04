package br.com.teste;

import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

public class Animacao2DTeste {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	private static float squareX = 0.0f;
	private static float squareY = 0.0f;
	private static float speedX = 0.01f;
	private static float speedY = 0.01f;

	public static void main(String[] args) {
		GLFWErrorCallback.createPrint(System.err).set();

		if (!glfwInit()) {
			throw new IllegalStateException("Falha ao inicializar o GLFW");
		}

		long window = glfwCreateWindow(WIDTH, HEIGHT, "OpenGL 2D Animation", NULL, NULL);
		if (window == NULL) {
			throw new RuntimeException("Falha ao criar a janela GLFW");
		}

		glfwMakeContextCurrent(window);
		glfwSwapInterval(1);
		GL.createCapabilities();
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glfwShowWindow(window);

		while (!glfwWindowShouldClose(window)) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

			drawSquare();

			glfwSwapBuffers(window);
			glfwPollEvents();

			update();
		}

		glfwTerminate();
	}

	private static void drawSquare() {
		glBegin(GL_QUADS);
		glColor3f(1.0f, 0.0f, 0.0f);
		glVertex2f(squareX, squareY);
		glVertex2f(squareX + 0.2f, squareY);
		glVertex2f(squareX + 0.2f, squareY + 0.2f);
		glVertex2f(squareX, squareY + 0.2f);
		glEnd();
	}

	private static void update() {
		squareX += speedX;
		squareY += speedY;

		if (squareX > 1.0f || squareX < -1.0f) {
			speedX = -speedX;
		}

		if (squareY > 1.0f || squareY < -1.0f) {
			speedY = -speedY;
		}
	}
}
