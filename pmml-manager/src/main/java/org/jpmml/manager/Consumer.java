/*
 * Copyright (c) 2012 University of Tartu
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holder nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.jpmml.manager;

import java.io.Serializable;
import java.util.List;

import org.dmg.pmml.DataDictionary;
import org.dmg.pmml.DataField;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.MiningField;
import org.dmg.pmml.MiningSchema;
import org.dmg.pmml.Model;
import org.dmg.pmml.Output;
import org.dmg.pmml.OutputField;

public interface Consumer extends Serializable {

	/**
	 * Returns a short description of the underlying {@link Model}
	 */
	String getSummary();

	/**
	 * Gets the definition of a field from the {@link DataDictionary}.
	 */
	DataField getDataField(FieldName name);

	/**
	 * Gets the independent (ie. input) fields of a {@link Model} from its {@link MiningSchema}.
	 */
	List<FieldName> getActiveFields();

	/**
	 * Gets the group fields of a {@link Model} from its {@link MiningSchema}.
	 *
	 * A model should have no more than 1 group field.
	 */
	List<FieldName> getGroupFields();

	/**
	 * Gets the order fields of a {@link Model} from its {@link MiningSchema}.
	 */
	List<FieldName> getOrderFields();

	/**
	 * Gets the dependent (ie. target in supervised training) fields of a {@link Model} from its {@link MiningSchema}.
	 */
	List<FieldName> getTargetFields();

	/**
	 * Convenience method for retrieving the sole target field.
	 *
	 * @return The sole target field, or <code>null</code> if it does not exist
	 *
	 * @throws InvalidFeatureException If the number of target fields is not exactly one.
	 *
	 * @see #getTargetFields()
	 */
	FieldName getTargetField();

	/**
	 * Gets the definition of a field from the {@link MiningSchema}.
	 *
	 * @see #getActiveFields()
	 * @see #getGroupFields()
	 * @see #getTargetFields()
	 */
	MiningField getMiningField(FieldName name);

	/**
	 * Gets the definition of a field from the {@link Output}
	 *
	 * @see #getOutputFields()
	 */
	OutputField getOutputField(FieldName name);

	/**
	 * Gets the output fields of a {@link Model} from its {@link Output}.
	 */
	List<FieldName> getOutputFields();
}