/*
 * Copyright 2016 Visu-IT GmbH, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.objecthunter.exp4j.tokenizer;

import static org.junit.Assert.*;

import org.junit.Test;

import net.objecthunter.exp4j.function.Functions;
import net.objecthunter.exp4j.operator.Operator;
import net.objecthunter.exp4j.operator.Operators;

public class TokenTest {

	@Test
	public void TestEqualArgumentSeparatorToken() {
		Token token = new ArgumentSeparatorToken();
		Token rightToken = new ArgumentSeparatorToken();
		Token wrongToken = new CloseParenthesesToken();
		assertEquals(token, rightToken);
		assertNotEquals(token, wrongToken);
	}

	@Test
	public void TestEqualCloseParenthesesToken() {
		Token token = new CloseParenthesesToken();
		Token rightToken = new CloseParenthesesToken();
		Token wrongToken = new OpenParenthesesToken();
		assertEquals(token, rightToken);
		assertNotEquals(token, wrongToken);
	}

	@Test
	public void TestEqualFunctionToken() {
		Token token = new FunctionToken(Functions.getBuiltinFunction("pow"));
		Token rightToken = new FunctionToken(Functions.getBuiltinFunction("pow"));
		Token wrongToken = new FunctionToken(Functions.getBuiltinFunction("exp"));
		assertEquals(token, rightToken);
		assertNotEquals(token, wrongToken);
	}

	@Test
	public void TestEqualNumberToken() {
		Token token = new NumberToken(1);
		Token rightToken = new NumberToken(1);
		Token wrongToken = new NumberToken(2);
		assertEquals(token, rightToken);
		assertNotEquals(token, wrongToken);
	}

	@Test
	public void TestEqualOpenParenthesesToken() {
		Token token = new OpenParenthesesToken();
		Token rightToken = new OpenParenthesesToken();
		Token wrongToken = new CloseParenthesesToken();
		assertEquals(token, rightToken);
		assertNotEquals(token, wrongToken);
	}

	@Test
	public void TestEqualOperatorToken() {
		Token token = new OperatorToken(Operators.getBuiltinOperator('+', 2));
		Token rightToken = new OperatorToken(Operators.getBuiltinOperator('+', 2));
		Token wrongToken = new OperatorToken(Operators.getBuiltinOperator('+', 1));
		Token wrongToken2 = new OperatorToken(Operators.getBuiltinOperator('-', 2));
		assertEquals(token, rightToken);
		assertNotEquals(token, wrongToken);
		assertNotEquals(token, wrongToken2);
	}

	@Test
	public void TestEqualVariableToken() {
		Token token = new VariableToken("a");
		Token rightToken = new VariableToken("a");
		Token wrongToken = new VariableToken("b");
		assertEquals(token, rightToken);
		assertNotEquals(token, wrongToken);
	}
}
