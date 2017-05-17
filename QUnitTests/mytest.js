QUnit.test( "Тесты", function (calc)
{
	var res=result('2','+','31');
	calc.ok(res=="33", "Тест на сложение" );
	
	var res=result('188','-','31');
	calc.ok(res=="157", "Тест на вычитание" );
	
	var res=result('288','/','15');
	calc.ok(res=="19.2", "Тест на деление" );
	
	var res=result('18','*','31');
	calc.ok(res=="558", "Тест на умножение" );

});