/*
 * Copyright 2014 Adrian Lapierre <adrian@softproject.com.pl>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.softproject.iu;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import pl.com.softproject.model.Task;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class AddTask extends WebPage {

    private Task task = new Task();

    public AddTask() {

        TextField nameField = new TextField("name", new PropertyModel(task, "name"));
        TextField descriptionField = new TextField("description", new PropertyModel(task, "description"));

        Form form = new LoginForm("taskForm");
        form.add(nameField);
        form.add(descriptionField);
        add(form);

    }

    class LoginForm extends Form {

        public LoginForm(String id) {
            super(id);
        }

        @Override
        public void onSubmit() {
            System.out.println("submit");
            System.out.println(task);
            
            TaskAdded page = new TaskAdded();
            setResponsePage(page);
        }

    }
}
