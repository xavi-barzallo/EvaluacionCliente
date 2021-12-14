package ec.edu.ups.pweb.Evaluacion.business;

import ec.edu.ups.pweb.demoapp.model.Departamento;

public interface DepartamentoONRemoto {

	public void insertar (Departamento p) throws Exception ;
	public void actualizar(Departamento op);
	public Departamento getBuscarDep(int codigoDep);
}
