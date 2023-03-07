import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Lottery {

	protected Shell shlLottery;
	private Label Rules;
	private Text tfInput;
	private Button btnPlay;
	private Label lbDisplay;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Lottery window = new Lottery();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
	
	private int generateLotteryNumber() {
		return (int)(Math.random() * 100);
	}

	
	private int checkMatch(int guess, int lotteryNumber) {
		if(guess == lotteryNumber) {
			return 10000;
		}else if(guess % 10 == lotteryNumber % 10 && guess / 10 == lotteryNumber / 10) {
			return 3000;
		}else if (guess % 10 == lotteryNumber % 10 || guess / 10 == lotteryNumber / 10 || guess % 10 == lotteryNumber / 10 || guess / 10 == lotteryNumber % 10) {
			return 1000;
		}else {
			return 0;
		}
	}
	
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlLottery.open();
		shlLottery.layout();
		while (!shlLottery.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLottery = new Shell();
		shlLottery.setSize(716, 472);
		shlLottery.setText("Lottery");
		
		Rules = new Label(shlLottery, SWT.NONE);
		Rules.setText("Rules:\r\n1.Match you win $10.000\r\n2.Match all digits you win $3.000\r\n3.Match one digit you win $1.000\r\n\r\nEnter your pick (only two digit number)");
		Rules.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		Rules.setBounds(154, 36, 383, 178);
		
		tfInput = new Text(shlLottery, SWT.BORDER);
		tfInput.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		tfInput.setBounds(208, 220, 273, 54);
		
		btnPlay = new Button(shlLottery, SWT.NONE);
		btnPlay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String guessString = tfInput.getText();
				int guess = Integer.parseInt(guessString);
				int lotteryNumber = generateLotteryNumber();
				int prize = checkMatch(guess, lotteryNumber);
				String result;
				if(prize > 0) {
					result = "you win $" + prize + ".";
				}else {
					result = "you didn't win";
				}
				lbDisplay.setText("Lottery Number: " + lotteryNumber + "\n" + result);
			}
		});
		btnPlay.setText("Play");
		btnPlay.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		btnPlay.setBounds(269, 359, 118, 54);
		
		lbDisplay = new Label(shlLottery, SWT.NONE);
		lbDisplay.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lbDisplay.setBounds(10, 280, 659, 70);

	}
}
