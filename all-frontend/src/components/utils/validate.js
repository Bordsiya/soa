export function addToValidationsAnotherError(errorAll, validError) {
    if (errorAll && errorAll.validations) {
        errorAll.validations.push(validError);
    } else {
        errorAll = Object;
        errorAll.validations = [];
        errorAll.validations.push(validError);
    }
    return errorAll;
}


export function validateId(id) {
    return id !== null && id > 0;
}

