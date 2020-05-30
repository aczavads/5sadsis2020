package aula20200529.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestesComCalculadora {
	@Mock
	Calculadora calc;
	
	@Test
	void testar_calculadora_mock() {
		calc = new Calculadora() {
			public double somar(double v1, double v2) {
				if (v1 == 2 && v2 == 2) {
					return 4;
				}
				return 0;
			}
			public double dividir(double dividendo, double divisor) {
				return 0;
			}
		};
		
		//when(calc.somar(2, 2)).thenReturn(4.0);
		when(calc.dividir(anyDouble(), 0.00)).thenThrow(IllegalArgumentException.class);

		
		assertEquals(4, calc.dividir(2, 0));
		
		assertEquals(4, calc.somar(2, 2));
		assertEquals(6, calc.somar(3, 3));
		
	}
	
	

}
