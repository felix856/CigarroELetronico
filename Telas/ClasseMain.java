public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText camponame,camposenha,campoanofumo,campoidade;

    RadioButton radiotabaco,radiovape,radiodual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        camponame = findViewById(R.id.cnme);
        camposenha = findViewById(R.id.cmpl);
        campoanofumo = findViewById(R.id.af2);
        campoidade = findViewById(R.id.Idade);
        radiotabaco = findViewById(R.id.radiobaco);
        radiovape = findViewById(R.id.radiovape);
        radiodual = findViewById(R.id.radiodual);


    }
}
