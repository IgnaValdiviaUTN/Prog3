package com.utn.PersistenciaJPA;

import com.utn.PersistenciaJPA.entidades.*;
import com.utn.PersistenciaJPA.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class PersistenciaJpaApplication {

	@Autowired
	public RubroRepository rubroRepository;
	@Autowired
	public ProductoRepository productoRepository;
	@Autowired
	public UsuarioRepository usuarioRepository;
	@Autowired
	public DomicilioRepository domicilioRepository;
	@Autowired
	public ClienteRepository clienteRepository;
	@Autowired
	public PedidoRepository pedidoRepository;
	@Autowired
	public DetallePedidoRepository detallePedidoRepository;
	@Autowired
	public FacturaRepository facturaRepository;
	@Autowired
	public ConfiguracionGeneralRepository configuracionGeneralRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersistenciaJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			System.out.println("---------Funciono------------");
			/*CONFIGURACION GENERAL*/
			ConfiguracionGeneral configuracionGeneral = ConfiguracionGeneral.builder()
					.cantidadCocineros(3)
					.emailEmpresa("empresa@empresa.com")
					.tokenMercadoPago("HSDF156SDF")
					.build();

			configuracionGeneralRepository.save(configuracionGeneral);


			/*USUARIOS*/
			Usuario user1 = Usuario.builder()
					.nombre("Igna")
					.rol("admin")
					.password("123")
					.build();

			Usuario user2 = Usuario
					.builder()
					.nombre("Pepe")
					.rol("empleado")
					.password("234")
					.build();

			usuarioRepository.save(user1);
			usuarioRepository.save(user2);

			/*CLIENTES*/
			Cliente cliente = Cliente.builder()
					.nombre("Cliente")
					.email("cliente1@gmail.com")
					.telefono("2616598471")
					.apellido("numero1")
					.build();


			Cliente cliente2 = Cliente.builder()
					.nombre("Cliente")
					.email("cliente2@gmail.com")
					.telefono("2616425694")
					.apellido("numero2")
					.build();

			clienteRepository.save(cliente);
			clienteRepository.save(cliente2);

			/*DOMICILIOS*/
			Domicilio domicilio = Domicilio.builder()
					.cliente(cliente)
					.calle("Besares")
					.numero(635)
					.localidad("Chacras de Coria")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.cliente(cliente)
					.calle("Italia")
					.numero(296)
					.localidad("Chacras de Coria")
					.build();

			Domicilio domicilio3 = Domicilio.builder()
					.cliente(cliente2)
					.calle("Rivadavia")
					.numero(234)
					.localidad("Godoy Cruz")
					.build();

			domicilioRepository.save(domicilio);
			domicilioRepository.save(domicilio2);
			domicilioRepository.save(domicilio3);


			/*PEDIDOS*/
			Pedido pedido1 = Pedido.builder()
					.fecha("3/9/2023")
					.horaEstimadaEntrega("10min")
					.estado(Pedido.Estado.INICIADO)
					.tipoEnvio(Pedido.TipoEnvio.DELIVERY)
					.total(250)
					.build();

			Pedido pedido2 = Pedido.builder()
					.fecha("5/9/2023")
					.horaEstimadaEntrega("5min")
					.estado(Pedido.Estado.PREPARACION)
					.tipoEnvio(Pedido.TipoEnvio.DELIVERY)
					.total(600)
					.build();

			Pedido pedido3 = Pedido.builder()
					.fecha("8/9/2023")
					.horaEstimadaEntrega("7min")
					.estado(Pedido.Estado.PREPARACION)
					.tipoEnvio(Pedido.TipoEnvio.RETIRA)
					.total(200)
					.build();


			/*FACTURA*/
			Factura factura= Factura.builder()
					.formaPago(Factura.FormaPago.EFECTIVO)
					.fecha(pedido1.getFecha())
					.descuento(0.00)
					.total(250.00)
					.build();
			pedido1.setFactura(factura);

			/*PRODUCTO*/
			Producto producto = Producto.builder()
					.tipo(Producto.Tipo.INSUMO)
					.denominacion("pizza napolitana")
					.foto("pizza.jpg")
					.unidadMedida("porciones")
					.precioCompra(200.00)
					.precioVenta(500.00)
					.receta("Receta 1")
					.tiempoEstimadoCocina(10)
					.stockActual(2)
					.stockMinimo(1)
					.build();

			Producto producto2 = Producto.builder()
					.tipo(Producto.Tipo.INSUMO)
					.denominacion("asado")
					.foto("asado.jpg")
					.unidadMedida("kg")
					.precioCompra(300.00)
					.precioVenta(450.00)
					.receta("Receta 2")
					.tiempoEstimadoCocina(2)
					.stockActual(2)
					.stockMinimo(1)
					.build();

			Producto producto3 = Producto.builder()
					.tipo(Producto.Tipo.INSUMO)
					.denominacion("carne molida")
					.foto("carne.jpg")
					.unidadMedida("kg")
					.precioCompra(300.00)
					.precioVenta(100.00)
					.receta("Receta 3")
					.tiempoEstimadoCocina(4)
					.stockActual(3)
					.stockMinimo(1)
					.build();

			/*RUBRO*/
			Rubro rubro= Rubro.builder()
					.denominacion("Comida Italiana")
					.build();

			Rubro rubro2= Rubro.builder()
					.denominacion("Comida Nacional")
					.build();

			rubro.agregarProducto(producto);
			rubro.agregarProducto(producto3);
			rubro2.agregarProducto(producto2);

			rubroRepository.save(rubro);
			rubroRepository.save(rubro2);

			/*DETALLE PEDIDO*/
			DetallePedido detalleP = DetallePedido.builder()
					.cantidad(3)
					.subtotal(200.00)
					.build();

			detalleP.setProducto(producto);

			DetallePedido detalleP2 = DetallePedido.builder()
					.cantidad(5)
					.subtotal(1200.00)
					.build();

			detalleP2.setProducto(producto);

			pedido1.agregarDetalle(detalleP);
			pedido1.agregarDetalle(detalleP2);

			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);
			pedidoRepository.save(pedido3);




			user2.agregarPedido(pedido1);
			user2.agregarPedido(pedido2);
			user2.agregarPedido(pedido3);

			domicilio.agregarPedido(pedido1);
			domicilio.agregarPedido(pedido2);
			domicilio3.agregarPedido(pedido3);

			cliente.agregarPedido(pedido1);
			cliente2.agregarPedido(pedido2);

			usuarioRepository.save(user1);
			usuarioRepository.save(user2);

			clienteRepository.save(cliente);
			clienteRepository.save(cliente2);

			domicilioRepository.save(domicilio);
			domicilioRepository.save(domicilio2);
			domicilioRepository.save(domicilio3);

		};
	}
}
