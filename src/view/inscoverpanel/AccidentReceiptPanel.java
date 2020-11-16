package view.inscoverpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ViewConstants.ELogin;
import constants.ViewConstants.EViewFrame;
import control.accidentRecipt.AccidentReceipt;
import control.accidentRecipt.AccidentReceiptListImpl;
import control.insuranceCover.InsuranceCoverImpl;
import view.mainFrame.MainFrame;

public class AccidentReceiptPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private Vector<Object> objects;
	private InsuranceCoverImpl insuranceCover;
	private AccidentReceiptListImpl accidentReceiptList;
	private AccidentReceipt accidentReceipt;
	private InsCoverPanel insCoverPanel;
	
	private JPanel information;
	private ActionHandler actionHandler;
	private JButton pay,back;

	private JPanel btnPanel;
	
	public AccidentReceiptPanel(InsCoverPanel insCoverPanel, InsuranceCoverImpl insuranceCover, AccidentReceiptListImpl accidentReceiptList, Vector<Object> vector) {
		setPreferredSize(new Dimension(600, 500));
		setLayout(null);
		
		this.insCoverPanel = insCoverPanel;
		this.insuranceCover = insuranceCover;
		this.accidentReceiptList = accidentReceiptList;
		
		this.objects = vector;
		for(AccidentReceipt accidentReceipt : this.accidentReceiptList.getAccidentReceiptList()) {
			if (accidentReceipt.getAccidentReceiptId() == (Integer)this.objects.get(0)) {
				this.accidentReceipt = accidentReceipt;
			}
		}
		
		information = new JPanel();
		information.setLocation(12, 10);
		information.setSize(576, 302);
		information.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"��������� �󼼳���"));
		information.setLayout(null);
		JLabel jLabel = new JLabel();
		jLabel.setBounds(5, 19, 275, 45);
		jLabel.setFont(EViewFrame.eFont.getFont());
		jLabel.setText("��������� ��ȣ : "+this.accidentReceipt.getAccidentReceiptId());
		information.add(jLabel);
		JLabel jLabel1 = new JLabel();
		jLabel1.setBounds(280, 19, 275, 45);
		jLabel1.setFont(EViewFrame.eFont.getFont());
		jLabel1.setText("��������� �̸� : "+this.accidentReceipt.getAccidentReceiptName());
		information.add(jLabel1);
		JLabel jLabel2 = new JLabel();
		jLabel2.setBounds(5, 54, 275, 45);
		jLabel2.setFont(EViewFrame.eFont.getFont());
		jLabel2.setText("���� �̸� : "+this.accidentReceipt.getCustomerName());
		information.add(jLabel2);
		JLabel jLabel3_1 = new JLabel();
		jLabel3_1.setText("���� ���� : "+this.accidentReceipt.getInsuranceType());
		jLabel3_1.setFont(EViewFrame.eFont.getFont());
		jLabel3_1.setBounds(5, 88, 275, 45);
		information.add(jLabel3_1);
		JLabel jLabel3 = new JLabel();
		jLabel3.setBounds(280, 88, 275, 45);
		jLabel3.setFont(EViewFrame.eFont.getFont());
		jLabel3.setText("���� ��� : "+this.accidentReceipt.getPaymentMethod());
		information.add(jLabel3);
		JLabel jLabel4 = new JLabel();
		jLabel4.setBounds(5, 123, 275, 45);
		jLabel4.setFont(EViewFrame.eFont.getFont());
		jLabel4.setText("��� ��¥ : "+this.accidentReceipt.getAccidentDate());
		information.add(jLabel4);
		JLabel jLabel5 = new JLabel();
		jLabel5.setBounds(280, 123, 275, 45);
		jLabel5.setFont(EViewFrame.eFont.getFont());
		jLabel5.setText("��� ��� : "+this.accidentReceipt.getAccidentPlace());
		information.add(jLabel5);
		JLabel jLabel7 = new JLabel();
		jLabel7.setBounds(280, 160, 275, 45);
		jLabel7.setFont(EViewFrame.eFont.getFont());
		jLabel7.setText("������ : "+this.accidentReceipt.getDiagnosisName());
		information.add(jLabel7);
		JLabel jLabel8 = new JLabel();
		jLabel8.setBounds(5, 160, 275, 45);
		jLabel8.setFont(EViewFrame.eFont.getFont());
		jLabel8.setText("������ : "+this.accidentReceipt.getHospitalName());
		information.add(jLabel8);
		JLabel jLabel9 = new JLabel();
		jLabel9.setBounds(280, 194, 275, 45);
		jLabel9.setFont(EViewFrame.eFont.getFont());
		jLabel9.setText("���� �Ը� : "+this.accidentReceipt.getDamageScale());
		information.add(jLabel9);
		JLabel jLabel10 = new JLabel();
		jLabel10.setBounds(5, 194, 275, 45);
		jLabel10.setFont(EViewFrame.eFont.getFont());
		jLabel10.setText("������� : "+this.accidentReceipt.isDeathStatus());
		information.add(jLabel10);
		JLabel jLabel10_1 = new JLabel();
		jLabel10_1.setBounds(5, 230, 543, 91);
		jLabel10_1.setText("�����Ȳ : "+this.accidentReceipt.getAccidentCircumstances());
		jLabel10_1.setFont(EViewFrame.eFont.getFont());
		information.add(jLabel10_1);
		JLabel jLabel2_1 = new JLabel();
		jLabel2_1.setText("���� �ֹε�Ϲ�ȣ : "+ this.accidentReceipt.getCustomerId());
		jLabel2_1.setFont(EViewFrame.eFont.getFont());
		jLabel2_1.setBounds(280, 54, 275, 45);
		information.add(jLabel2_1);
		this.add(information);
		
		this.actionHandler = new ActionHandler();
		btnPanel = new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setBounds(12, 322, 576, 168);
		btnPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		pay = new JButton("����� �����ϱ�");
		pay.setFont(EViewFrame.eFont.getFont());
		pay.setBounds(12, 10, 552, 42);
		pay.addActionListener(actionHandler);
		btnPanel.add(pay);
		back = new JButton("���ư���");
		back.setFont(EViewFrame.eFont.getFont());
		back.setBounds(12, 58, 552, 42);
		back.addActionListener(actionHandler);
		btnPanel.add(back);
		this.add(btnPanel);
	}
	
	public void buttonClick(Object source) {
		if (source.equals(this.pay)) {
			this.insuranceCover.acceptAccident(this.accidentReceipt.getAccidentReceiptId());
			JOptionPane.showMessageDialog(this, "����� ������ �Ϸ�Ǿ����ϴ�.");
		}else {
			this.removeAll();
			this.insCoverPanel.createPanel();
			this.information.setVisible(false);
			this.btnPanel.setVisible(false);
		}
	}
	protected class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getSource());
		}
	}
}