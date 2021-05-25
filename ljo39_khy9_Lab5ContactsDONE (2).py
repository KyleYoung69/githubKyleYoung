def add_contact(contacts, first_name, last_name, email, phone_number, age):
    contacts[first_name + ' ' + last_name] = [first_name, last_name, email, phone_number, age]
# first, we establish a dictionary that calls a contact by their first and
# last name, to get their information


def has_contact(contacts, first_name, last_name):
    if first_name + ' ' + last_name in contacts:
        return True
    else:
        return False
# this function checks if you have the contact already


def get_contact_age(contacts, first_name, last_name):
    if has_contact(contacts, first_name, last_name) = True:
        return contacts[first_name + ' ' + last_name][4]
    else:
        return None
# this function calls the contacts age


def get_contact_email(contacts, first_name, last_name):
    if has_contact(contacts, first_name, last_name):
        return contacts[first_name + ' ' + last_name][2]
    else:
        return None
# this function calls the contacts email


def get_contact_phone_number(contacts, first_name, last_name):
    if has_contact(contacts, first_name, last_name):
        return contacts[first_name + ' ' + last_name][3]
    else:
        return None
# this function calls the contacts phone number


def update_contact_age(contacts, first_name, last_name, age):
    if has_contact(contacts, first_name, last_name):
        contacts[first_name + ' ' + last_name][4] = age
        return True
    else:
        return False
# this function changes the age of the contact
# for update we simply have the variable replace the one in the list we select


def update_contact_email(contacts, first_name, last_name, email):
    if has_contact(contacts, first_name, last_name):
        contacts[first_name + ' ' + last_name][2] = email
        return True
    else:
        return False
# this function will change the contacts email


def update_contact_phone_number(contacts, first_name, last_name, phone_number):
    if has_contact(contacts, first_name, last_name):
        contacts[first_name + ' ' + last_name][3] = phone_number
        return True
    else:
        return False
# the final update function changes the contacts phone number


def get_contact_as_str(contacts, first_name, last_name):
    if has_contact(contact, first_name, last_name):
        return F"{first_name} {last_name}"\
               F"E-mail: {get_contact_email}"\
               F"Phone#: {get_contact_phone_number}"\
               F"Age: {get_contact_age}"
    else:
        # the string function formats all the contact info properly

        return F"No contact data for {first_name} {last_name} found"


def remove_contact(contacts, first_name, last_name):
    if has_contact(contact, first_name, last_name):
        return contacts.pop(first_name + ' ' + last_name)
    else:
        return None
# the rmove function simply removes functions and leaves them blank
