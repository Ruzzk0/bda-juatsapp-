
package componente;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ruzzky
 */
public class ComponentResizer extends MouseAdapter {

    private final static Dimension MINIMUM_SIZE = new Dimension(10, 10);
	private final static Dimension MAXIMUM_SIZE =
		new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);

	private static Map<Integer, Integer> cursors = new HashMap<Integer, Integer>();
	{
		cursors.put(1, Cursor.N_RESIZE_CURSOR);
		cursors.put(2, Cursor.W_RESIZE_CURSOR);
		cursors.put(4, Cursor.S_RESIZE_CURSOR);
		cursors.put(8, Cursor.E_RESIZE_CURSOR);
		cursors.put(3, Cursor.NW_RESIZE_CURSOR);
		cursors.put(9, Cursor.NE_RESIZE_CURSOR);
		cursors.put(6, Cursor.SW_RESIZE_CURSOR);
		cursors.put(12, Cursor.SE_RESIZE_CURSOR);
	}

	private Insets dragInsets;
	private Dimension snapSize;

	private int direction;
	protected static final int NORTH = 1;
	protected static final int WEST = 2;
	protected static final int SOUTH = 4;
	protected static final int EAST = 8;

	private Cursor sourceCursor;
	private boolean resizing;
	private Rectangle bounds;
	private Point pressed;
	private boolean autoscrolls;
	private boolean autoLayout;

	private Dimension minimumSize = MINIMUM_SIZE;
	private Dimension maximumSize = MAXIMUM_SIZE;

	/**
	 *Constructor de conveniencia. Todos los bordes son redimensionables en incrementos de
         * un solo píxel. Los componentes deben registrarse por separado.
	 */
	public ComponentResizer()
	{
		this(new Insets(5, 5, 5, 5), new Dimension(1, 1));
	}
        /**
         * Constructor conveniente. Todos los bordes son redimensionables en incrementos de un solo píxel. Los componentes pueden registrarse cuando se crea la clase o pueden registrarse por separado después.
         *
         * @param components componentes que se registrarán automáticamente
         */
        public ComponentResizer(Component... components)
        {
            this(new Insets(5, 5, 5, 5), new Dimension(1, 1), components);
        }

        /**
         * Constructor conveniente. Los bordes elegibles son redimensionables en incrementos de un solo píxel. Los componentes pueden registrarse cuando se crea la clase o pueden registrarse por separado después.
         *
         * @param dragInsets Insets que especifican qué bordes son elegibles para ser redimensionados.
         * @param components componentes que se registrarán automáticamente
         */
        public ComponentResizer(Insets dragInsets, Component... components)
        {
            this(dragInsets, new Dimension(1, 1), components);
        }

        /**
         * Crea un ComponentResizer.
         *
         * @param dragInsets Insets que especifican qué bordes son elegibles para ser redimensionados.
         * @param snapSize Especifica la dimensión a la cual el borde se ajustará cuando se arrastre. El ajuste ocurre en el punto medio.
         * @param components componentes que se registrarán automáticamente
         */
        public ComponentResizer(Insets dragInsets, Dimension snapSize, Component... components)
        {
            setDragInsets(dragInsets);
            setSnapSize(snapSize);
            registerComponent(components);
        }


	/**
         * Obtiene la propiedad de diseño automático.
         *
         * @return la propiedad de diseño automático
         */
	public boolean isAutoLayout()
	{
		return autoLayout;
	}

	/**
         * Establece la propiedad de diseño automático.
         *
         * @param autoLayout cuando es verdadero, se invocará el diseño en el contenedor padre
         */
	public void setAutoLayout(boolean autoLayout)
	{
		this.autoLayout = autoLayout;
	}

	/**
         * Obtiene los márgenes de arrastre.
         *
         * @return los márgenes de arrastre
         */
	public Insets getDragInsets()
	{
		return dragInsets;
	}

	/**
         * Establece los márgenes de arrastre. Los márgenes especifican un área donde 
         * se reconocen los eventos de mouse arrastrado desde el borde hacia adentro.
         * Un valor de 0 para cualquier tamaño implicará que el borde no es redimensionable.
         * De lo contrario, el cursor de arrastre apropiado aparecerá cuando el mouse esté
         * dentro del área de borde redimensionable.
         *
         * @param dragInsets los márgenes para controlar qué bordes son redimensionables.
         */
	public void setDragInsets(Insets dragInsets)
	{
		validateMinimumAndInsets(minimumSize, dragInsets);

		this.dragInsets = dragInsets;
	}

	/**
         * Obtiene el tamaño máximo del componente.
         *
         * @return el tamaño máximo
         */
	public Dimension getMaximumSize()
	{
		return maximumSize;
	}

	/**
         * Especifica el tamaño máximo para el componente. 
         * El componente seguirá estando limitado por el tamaño de su contenedor padre.
         *
         * @param maximumSize el tamaño máximo para un componente.
         */
	public void setMaximumSize(Dimension maximumSize)
	{
		this.maximumSize = maximumSize;
	}

	/**
         * Obtiene el tamaño mínimo del componente.
         *
         * @return el tamaño mínimo
         */
	public Dimension getMinimumSize()
	{
		return minimumSize;
	}

	/**
         * Especifica el tamaño mínimo para el componente. 
         * El tamaño mínimo está limitado por los márgenes de arrastre.
         *
         * @param minimumSize el tamaño mínimo para un componente.
         */
	public void setMinimumSize(Dimension minimumSize)
	{
		validateMinimumAndInsets(minimumSize, dragInsets);

		this.minimumSize = minimumSize;
	}

	/**
         * Elimina los escuchadores de eventos del componente especificado.
         *
         * @param component el componente del cual se eliminarán los escuchadores de eventos
         */
	public void deregisterComponent(Component... components)
	{
		for (Component component : components)
		{
			component.removeMouseListener( this );
			component.removeMouseMotionListener( this );
		}
	}

	/**
         * Agrega los escuchadores de eventos necesarios al componente especificado.
         *
         * @param component el componente al cual se agregarán los escuchadores de eventos
         */
	public void registerComponent(Component... components)
	{
		for (Component component : components)
		{
			component.addMouseListener( this );
			component.addMouseMotionListener( this );
		}
	}

	/**
         * Obtiene el tamaño de arrastre.
         *
         * @return el tamaño de arrastre
         */
	public Dimension getSnapSize()
	{
		return snapSize;
	}

	/**
         * Controla cuántos píxeles debe arrastrarse un borde 
         * antes de que cambie el tamaño del componente.
         * El borde se ajustará al tamaño una vez que el arrastre haya pasado la marca intermedia.
         *
         * @param snapSize el objeto Dimension permite
         * especificar por separado un tamaño de arrastre horizontal y vertical.
         */
	public void setSnapSize(Dimension snapSize)
	{
		this.snapSize = snapSize;
	}

	/**
        * Cuando el tamaño mínimo de los componentes es menor que los insertos de arrastre, entonces
        * no podemos determinar qué borde debe cambiarse de tamaño, por lo que debemos
        * evitar que esto suceda.
        */
	private void validateMinimumAndInsets(Dimension minimum, Insets drag)
	{
		int minimumWidth = drag.left + drag.right;
		int minimumHeight = drag.top + drag.bottom;

		if (minimum.width  < minimumWidth
		||  minimum.height < minimumHeight)
		{
			String message = "Minimum size cannot be less than drag insets";
			throw new IllegalArgumentException( message );
		}
	}

	/**
	 */
	@Override
	public void mouseMoved(MouseEvent e)
	{
		Component source = e.getComponent();
		Point location = e.getPoint();
		direction = 0;

		if (location.x < dragInsets.left)
			direction += WEST;

		if (location.x > source.getWidth() - dragInsets.right - 1)
			direction += EAST;

		if (location.y < dragInsets.top)
			direction += NORTH;

		if (location.y > source.getHeight() - dragInsets.bottom - 1)
			direction += SOUTH;

		//  El mouse ya no está sobre un borde redimensionable
		if (direction == 0)
		{
			source.setCursor( sourceCursor );
		}
		else  // use el cursor redimensionable apropiado
		{
			int cursorType = cursors.get( direction );
			Cursor cursor = Cursor.getPredefinedCursor( cursorType );
			source.setCursor( cursor );
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		if (! resizing)
		{
			Component source = e.getComponent();
			sourceCursor = source.getCursor();
		}
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		if (! resizing)
		{
			Component source = e.getComponent();
			source.setCursor( sourceCursor );
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		//	 El evento mouseMoved actualiza continuamente esta variable.

		if (direction == 0) return;

		// Configuración para redimensionar. Todos los cálculos de arrastre futuros se realizan en función 
                //de los límites originales del componente y la ubicación presionada del mouse.

		resizing = true;

		Component source = e.getComponent();
		pressed = e.getPoint();
		SwingUtilities.convertPointToScreen(pressed, source);
		bounds = source.getBounds();

		// Asegurarse de que autoscrolls sea falso permitirá un redimensionamiento más suave de los componentes.


		if (source instanceof JComponent)
		{
			JComponent jc = (JComponent)source;
			autoscrolls = jc.getAutoscrolls();
			jc.setAutoscrolls( false );
		}
	}

	/**
	 *  Restaurar el estado original del Componente
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
		resizing = false;

		Component source = e.getComponent();
		source.setCursor( sourceCursor );

		if (source instanceof JComponent)
		{
			((JComponent)source).setAutoscrolls( autoscrolls );
		}

		if (autoLayout)
		{
			Component parent = source.getParent();

			if (parent != null)
			{
				if (parent instanceof JComponent)
				{
					((JComponent)parent).revalidate();
				}
				else
				{
					parent.validate();
				}
			}
		}
	}

	/**
         * Redimensiona el componente asegurándose de que la ubicación y 
         * el tamaño estén dentro de los límites del contenedor padre y
         * que el tamaño esté dentro de las restricciones mínimas y máximas.
         *
         * Todos los cálculos se realizan utilizando los límites
         * del componente cuando comenzó la redimensión.
         */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		if (resizing == false) return;

		Component source = e.getComponent();
		Point dragged = e.getPoint();
		SwingUtilities.convertPointToScreen(dragged, source);

		changeBounds(source, direction, bounds, pressed, dragged);
	}

	protected void changeBounds(Component source, int direction, Rectangle bounds, Point pressed, Point current)
	{
		//  Start with original locaton and size

		int x = bounds.x;
		int y = bounds.y;
		int width = bounds.width;
		int height = bounds.height;

		//  Comenzar con la ubicación y el tamaño originales

		if (WEST == (direction & WEST))
		{
			int drag = getDragDistance(pressed.x, current.x, snapSize.width);
//			int maximum = Math.min(width + x, maximumSize.width);
			int maximum = Math.min(width + x - 10, maximumSize.width);
			drag = getDragBounded(drag, snapSize.width, width, minimumSize.width, maximum);

			x -= drag;
			width += drag;
		}

		if (NORTH == (direction & NORTH))
		{
			int drag = getDragDistance(pressed.y, current.y, snapSize.height);
//			int maximum = Math.min(height + y, maximumSize.height);
			int maximum = Math.min(height + y - 10, maximumSize.height);
			drag = getDragBounded(drag, snapSize.height, height, minimumSize.height, maximum);

			y -= drag;
			height += drag;
		}

		//  Redimensionar el borde Oeste o Norte afecta al tamaño y la ubicación

		if (EAST == (direction & EAST))
		{
			int drag = getDragDistance(current.x, pressed.x, snapSize.width);
			Dimension boundingSize = getBoundingSize( source );
			int maximum = Math.min(boundingSize.width - x, maximumSize.width);
			drag = getDragBounded(drag, snapSize.width, width, minimumSize.width, maximum);
			width += drag;
		}
//Redimensionar el borde Este o Sur solo afecta al tamaño
		if (SOUTH == (direction & SOUTH))
		{
			int drag = getDragDistance(current.y, pressed.y, snapSize.height);
			Dimension boundingSize = getBoundingSize( source );
			int maximum = Math.min(boundingSize.height - y, maximumSize.height);
			drag = getDragBounded(drag, snapSize.height, height, minimumSize.height, maximum);
			height += drag;
		}

		source.setBounds(x, y, width, height);
		source.validate();
	}

	/*
	 *  Determinar qué tan lejos se ha movido el mouse desde donde comenzó el arrastre
	 */
	private int getDragDistance(int larger, int smaller, int snapSize)
	{
		int halfway = snapSize / 2;
		int drag = larger - smaller;
		drag += (drag < 0) ? -halfway : halfway;
		drag = (drag / snapSize) * snapSize;

		return drag;
	}

	/*
	 *  Ajuste el valor de arrastre para que esté dentro del rango mínimo y máximo.
	 */
	private int getDragBounded(int drag, int snapSize, int dimension, int minimum, int maximum)
	{
		while (dimension + drag < minimum)
			drag += snapSize;

		while (dimension + drag > maximum)
			drag -= snapSize;


		return drag;
	}

	/*
	 *  Mantenga el tamaño del componente dentro de los límites de su padre.
	 */
	private Dimension getBoundingSize(Component source)
	{
		if (source instanceof Window)
		{
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Rectangle bounds = env.getMaximumWindowBounds();
			return new Dimension(bounds.width, bounds.height);
		}
		else
		{
//			return source.getParent().getSize();
			Dimension d = source.getParent().getSize();
			d.width += -10;
			d.height += -10;
			return d;
		}
	}

    public void getMaximumSize(Dimension screenSize) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    
}
