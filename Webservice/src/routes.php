<?php
// Routes

$app->get('/departamento/list', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT * FROM dep') as $row){
		$return[] = $row;
	};

	return $response->withJson($return);
});

$app->get('/departamento/list/locais', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT DISTINCT local_dep FROM dep') as $row){
		$return[] = $row;
	};

	return $response->withJson($return);
});

$app->get('/funcionario/list', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT * FROM v_emp') as $row){
		$result['n_emp']    = $row['f_n_emp'];
		$result['nome_emp'] = $row['f_nome_emp'];
		$result['cargo']    = $row['f_cargo'];
		$result['data_adm'] = $row['f_data_adm'];
		$result['sal']      = $row['f_sal'];
		$result['com']      = $row['f_com'];

		$result['departamento'] = [
			'n_dep'    => $row['d_n_dep'],
			'nome_dep' => $row['d_nome_dep'],
			'local_dep' => $row['d_local_dep'],
		];

		//if($row['c_n_emp'] != null){
			$result['chefe'] = [
				'n_emp' => $row['c_n_emp'],
				'nome_emp' => $row['c_nome_emp'],
				'cargo' => $row['c_cargo'],
				'data_adm' => $row['c_data_adm'],
				'sal' => $row['c_sal'],
				'com'=> $row['c_com']
			];
		//}

		$return[] = $result;
	};

	return $response->withJson($return);
});


$app->get('/funcionario/list/{local_dep}', function ($request, $response) {
	$local_dep = $request->getAttribute('local_dep');

	$db  = $this->db;
	$sth = $db->prepare('SELECT emp.* 
                       FROM dep
                          , emp
                      WHERE dep.n_dep = emp.n_dep
                       AND dep.local_dep = ?');

	$sth->execute(array($local_dep));

	$return = [];

	foreach($sth as $row){
		$return[] = $row;
	};

	return $response->withJson($return);
});


$app->post('/departamento/new', function ($request, $response) {
	
	$listDepartamento = $request->getParsedBody();
	$db = $this->db;
	$sth = $db->prepare("INSERT INTO dep(nome_dep, local_dep) VALUES (:nome_dep, :local_dep)");	
	
	$insertDepartamento["nome_dep"]= $listDepartamento["nome_dep"];
	$insertDepartamento["local_dep"]= $listDepartamento["local_dep"];
	
	$sth->execute($insertDepartamento);
	
	return $response->withJson($insertDepartamento); 

});

$app->post('/funcionario/new', function ($request, $response) {
	
	$listFuncionario = $request->getParsedBody();
	$db = $this->db;
	$sth = $db->prepare("INSERT INTO emp(nome_emp, cargo, sal) VALUES (:nome_emp, :cargo, :sal, :dep)");	
	
	$insertFuncionario["nome_emp"]= $listFuncionario["nome_emp"];
	$insertFuncionario["cargo"]= $listFuncionario["cargo"];
	$insertFuncionario["sal"]= $listFuncionario["sal"];
	$insertFuncionario["dep"]= 1;
	
	$sth->execute($insertFuncionario);
	
	return $response->withJson($insertFuncionario); 

});



