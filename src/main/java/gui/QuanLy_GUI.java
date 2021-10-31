package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class QuanLy_GUI extends JFrame {
	
	private KhachHang khachHang = null;
	private NhanVien nhanVien = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private MuaHang muaHangGUI;
	private TrangChu_GUI trangChuGUI = new TrangChu_GUI();
	private TrangChaoMung_GUI TrangChaoMungGUI = new TrangChaoMung_GUI();
	private DangNhap_GUI dangNhapGUI = new DangNhap_GUI();
	private DangKy_GUI dangKyGUI = new DangKy_GUI();
	private ThongKe_GUI thongKeGUI = new ThongKe_GUI();
	private Sach_GUI SachGUI = new Sach_GUI();
	private LoaiSanPham_GUI LoaiSanPhamGUI = new LoaiSanPham_GUI();
	private HoaDon_GUI hoaDonGUI = new HoaDon_GUI();
	private DatHang_GUI datHangGUI = new DatHang_GUI();
	private KhachHang_GUI khachHangGUI = new KhachHang_GUI();
	private NhanVien_GUI nhanVienGUI = new NhanVien_GUI();
	private TaoTaiKhoan_GUI taoTaiKhoanGUI = new TaoTaiKhoan_GUI();
	private ThongKeSanPhamBanChay_GUI thongKeSPBCGUI = new ThongKeSanPhamBanChay_GUI();
	private ThongKeSPDaHet_GUI thongKeSPDBHGUI = new ThongKeSPDaHet_GUI();
	private ThongKeKHTiemNang_GUI thongKeKHTNGUI = new ThongKeKHTiemNang_GUI();
	
	private JMenuBar menuBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLy_GUI frame = new QuanLy_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public QuanLy_GUI() throws SQLException {
		
		
		
		setTitle("Quản lý hiệu sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(0, 0, 1320, 700);
		
		
		menuGUI();
		contentPane = dangNhapGUI.getContentPane();
		renderMain(dangNhapGUI.getContentPane(), "dangnhap");
//		TaiKhoan taiKhoan = new TaiKhoanDAO().getTaiKhoan("admin");
//		khachHang = new KhachHangDAO().getKhachHangByMaTK(taiKhoan.getId());
//		System.out.println(khachHang);
//		
//		nhanVien = new NhanVienDAO().getNhanVienByMaTK(taiKhoan.getId());
//		System.out.println(nhanVien);
//		
//		muaHangGUI = new MuaHang(khachHang);
//		renderMain(TrangChaoMungGUI.getContentPane(), "chao mung");
//		menuBar.setVisible(true);
		handleLogin();
		handleRegister();
	}
	
	public void menuGUI() {
		menuBar = new JMenuBar();
		
		this.setJMenuBar(menuBar);
		menuBar.setVisible(false);
		
		JMenu mnTrangChu = new JMenu("Trang ch\u1EE7");
		menuBar.add(mnTrangChu);
		
		JMenu mnHoaDon = new JMenu("Hóa đơn");
		menuBar.add(mnHoaDon);
		
		JMenuItem mntmQLHoaDon = new JMenuItem("Quản lý hóa đơn");
		mnHoaDon.add(mntmQLHoaDon);
		
		JMenuItem mntmTimKiemHD = new JMenuItem("Tìm kiếm hóa đơn");
		mnHoaDon.add(mntmTimKiemHD);
		
		JMenu mnSanPham = new JMenu("Sản phẩm");
		menuBar.add(mnSanPham);
		
		JMenuItem mntmQLSach = new JMenuItem("Quản lý sách");
		mnSanPham.add(mntmQLSach);
		
		JMenuItem mntmQLSPKhac = new JMenuItem("Quản lý sản phẩm khác");
		mnSanPham.add(mntmQLSPKhac);
		
		JMenuItem mntmDanhMuc = new JMenuItem("Quản lý loại sản phẩm");
		mnSanPham.add(mntmDanhMuc);
		
		JMenuItem mntmTimKiemSach = new JMenuItem("Tìm kiếm sách");
		mnSanPham.add(mntmTimKiemSach);
		
		JMenuItem mntmTimKiemSPKhac = new JMenuItem("Tìm kiếm sản phẩm khác");
		mnSanPham.add(mntmTimKiemSPKhac);
		
		JMenuItem mntmTimKiemDMSP = new JMenuItem("Tìm kiếm danh mục sản phẩm");
		mnSanPham.add(mntmTimKiemDMSP);
		
		JMenuItem mntmThongKeSPBanChay = new JMenuItem("Thống kê sản phẩm bán chạy");
		mnSanPham.add(mntmThongKeSPBanChay);
		
		JMenuItem mntmThongKeSPBanHet = new JMenuItem("Thống kê sản phẩm đã hết");
		mnSanPham.add(mntmThongKeSPBanHet);
		
//		JMenu mnDanhMucSanPham = new JMenu("Danh mục sản phẩm");
//		menuBar.add(mnDanhMucSanPham);
		
		JMenu mnKhachHang = new JMenu("Khách hàng");
		menuBar.add(mnKhachHang);
		
		JMenuItem mntmQuanLyKH = new JMenuItem("Quản lý khách hàng");
		mnKhachHang.add(mntmQuanLyKH);
		
		JMenuItem mntmMuaHang = new JMenuItem("Mua hàng");
		mnKhachHang.add(mntmMuaHang);
		
		JMenuItem mntmDonDatHang = new JMenuItem("Đơn đặt hàng");
		mnKhachHang.add(mntmDonDatHang);
		
		JMenuItem mntmTimKiemKH = new JMenuItem("Tìm kiếm khách hàng");
		mnKhachHang.add(mntmTimKiemKH);
		
		JMenuItem mntmThongKeKHTN = new JMenuItem("Thống kê khách hàng tiềm năng");
		mnKhachHang.add(mntmThongKeKHTN);
		
		JMenu mnNhanVien = new JMenu("Nhân viên");
		menuBar.add(mnNhanVien);
		
		JMenuItem mntmQuanLyNhanVien = new JMenuItem("Quản lý nhân viên");
		mnNhanVien.add(mntmQuanLyNhanVien);
		
		JMenuItem mntmTimKiemNV = new JMenuItem("Tìm kiếm nhân viên");
		mnNhanVien.add(mntmTimKiemNV);
		
		JMenuItem mntmTaoTaiKhoan = new JMenuItem("Tạo tài khoản");
		mnNhanVien.add(mntmTaoTaiKhoan);
		
		JMenuItem mntmThongKe = new JMenuItem("Thống kê");
		mnNhanVien.add(mntmThongKe);
		
		
		
		
		mnTrangChu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				renderMain(TrangChaoMungGUI.getContentPane(), "chaomung");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {}
			
			@Override
			public void menuCanceled(MenuEvent e) {}
		});
		
		mntmQLHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				renderMain(hoaDonGUI.getContentPane(), "hoadon");
			}
		});
		
		mntmTimKiemHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		mntmQLSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				renderMain((JPanel) SachGUI.getContentPane(), "sanpham");
			}
		});
		
		mntmQLSPKhac.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		mntmDanhMuc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain((JPanel) LoaiSanPhamGUI.getContentPane(), "danhmucsanpham");
			}
		});
		
		mntmTimKiemSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		mntmTimKiemSPKhac.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		mntmTimKiemDMSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		mntmThongKeSPBanChay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				renderMain(thongKeSPBCGUI.getContentPane(), "thongkespbc");
			}
		});
		
		
		mntmThongKeSPBanHet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(thongKeSPDBHGUI.getContentPane(), "thongkespdbh");
			}
		});
		
		
		mntmQuanLyKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(khachHangGUI.getContentPane(), "khachhang");
			}
		});
		
		mntmMuaHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				renderMain(muaHang.getContentPane(), "muahang");
				muaHangGUI.setVisible(true);
				muaHangGUI.setLocationRelativeTo(contentPane);
//				muaHangGUI.setAlwaysOnTop(true);
//				muaHangGUI.setAlwaysOnTop(false);
//				trangChuGUI.setVisible(true);
			}
		});
		
		mntmDonDatHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(datHangGUI.getContentPane(), "dondathang");
				try {
					datHangGUI.renderData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mntmTimKiemKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		mntmThongKeKHTN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				renderMain(thongKeKHTNGUI.getContentPane(), "thongkekhtn");
			}
		});
		
		
		mntmQuanLyNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(nhanVienGUI.getContentPane(), "nhanvien");
				
			}
		});
		
		mntmThongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(thongKeGUI.getContentPane(), "thongke");
			}
		});
		
		mntmTimKiemNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				renderMain(thongKeGUI.getContentPane(), "thongke");
			}
		});
		
		mntmTaoTaiKhoan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				taoTaiKhoanGUI.main(null);
				taoTaiKhoanGUI.setVisible(true);
				taoTaiKhoanGUI.setLocationRelativeTo(contentPane);
//				renderMain(muaHang.getContentPane(), "muahang");
			}
		});

	}
	
	public void renderMain(JPanel contentPane, String tab) {
		this.remove(this.contentPane);
        this.revalidate();
        this.repaint();
        this.contentPane = contentPane;
        this.setContentPane(contentPane);
        this.revalidate();
        this.repaint();
        
        System.out.println("-> "+tab);
		if(tab.equals("thongke")) {
			
		}
		
	}
	
	public void handleLogin() {
		dangNhapGUI.btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(dangNhapGUI.checkPassword()) {
						System.out.println("dang nhap thanh cong");
						TaiKhoan taiKhoan = new TaiKhoanDAO().getTaiKhoan(dangNhapGUI.getTxtUserName().getText());
						khachHang = new KhachHangDAO().getKhachHangByMaTK(taiKhoan.getId());
						System.out.println(khachHang);
						
						nhanVien = new NhanVienDAO().getNhanVienByMaTK(taiKhoan.getId());
						System.out.println(nhanVien);
						
						muaHangGUI = new MuaHang(khachHang);
						renderMain(TrangChaoMungGUI.getContentPane(), "chao mung");
						menuBar.setVisible(true);
					}else {
						System.out.println("sai mat khau");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		dangNhapGUI.btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//			System.out.println("hi");
				renderMain(dangKyGUI.getContentPane(), "dangky");
			}
		});
	}
	
	public void handleRegister() {
		dangKyGUI.btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				renderMain(dangNhapGUI.getContentPane(), "login");
			}
		});
		
		dangKyGUI.btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(dangKyGUI.dangKy()) {
						renderMain(dangNhapGUI.getContentPane(), "login");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
}
